package com.kawal.malang.officer.presentation.briefing.create

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.briefing.BriefingData
import com.kawal.malang.officer.data.model.panic.report.CategoryData
import com.kawal.malang.officer.databinding.ActivityCreateBriefingBinding
import com.kawal.malang.officer.databinding.CategoryItemBinding
import com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter
import com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModel
import com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@AndroidEntryPoint
class CreateBriefingActivity : AppCompatActivity() {

    companion object {
        const val IS_EDIT = "IS_EDIT"
        const val DATA = "DATA"
        const val CATEGORY = "CATEGORY"
    }

    private lateinit var binding: ActivityCreateBriefingBinding
    private lateinit var viewModel: BriefingViewModel
    private lateinit var dialog: Dialog

    @Inject
    lateinit var factory: BriefingViewModelFactory
    @Inject
    lateinit var reportCategoryAdapter: ReportCategoryAdapter

    private var isEdit = false
    private var data: BriefingData? = null
    private var categories: ArrayList<CategoryData>? = arrayListOf()
    private var categoryId = ""
    private var tanggal = ""
    private var file: File? = null
    private val body = hashMapOf<String, RequestBody>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBriefingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, factory)[BriefingViewModel::class.java]
        dialog = AppUtil.loading(this)

        initAppBar()
        initRecyclerView()
        setData()

        binding.apply {
            btnUpload.setOnClickListener { takeImage() }
            ivPhoto.setOnClickListener { takeImage() }
            btnDate.setOnClickListener { pickDate() }
            btnSave.setOnClickListener {
                val title = "${etTitle.editText?.text}"
                val desc = "${etDescription.editText?.text}"
                val loc = "${etLocation.editText?.text}"
                if (!isEdit && title.isEmpty() && desc.isEmpty() && loc.isEmpty() && categoryId == ""
                    && tanggal == "" && file == null) {
                    etTitle.error = "Must be filled"
                    etDescription.error = "Must be filled"
                    etLocation.error = "Must be filled"
                } else {
                    body["judul"] = RequestBody.create(MultipartBody.FORM, title)
                    body["deskripsi"] = RequestBody.create(MultipartBody.FORM, desc)
                    body["lokasi"] = RequestBody.create(MultipartBody.FORM, loc)

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.ivPhoto.setOnClickListener { takeImage() }
    }

    @SuppressLint("SetTextI18n")
    private fun initAppBar() {
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        binding.appbar.apply {
            tbBack.setOnClickListener { finish() }
            tbTitle.text = if (isEdit) "Buat Laporan Briefing" else "Edit Laporan Briefing"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData() {
        isEdit = intent.getBooleanExtra(IS_EDIT, false)
        categories = intent.getParcelableArrayListExtra(CATEGORY)
        reportCategoryAdapter.differ.submitList(categories)
        if (isEdit) {
            data = intent.getParcelableExtra(DATA)
            binding.apply {
                etTitle.editText?.setText(data?.judul)
                etDescription.editText?.setText(data?.deskripsi)
                etLocation.editText?.setText(data?.lokasi)
                tvCategory.text = data?.kategori?.nama
                tvCategory.setTextColor(ContextCompat.getColor(binding.root.context,
                    R.color.black))
                btnUpload.visibility = GONE
                ivPhoto.visibility = VISIBLE
                if (file != null) {
                    Glide.with(ivPhoto.context)
                        .load(file)
                        .centerCrop()
                        .into(ivPhoto)
                } else {
                    Glide.with(ivPhoto.context)
                        .load(data?.foto)
                        .centerCrop()
                        .into(ivPhoto)
                }
                tvDate.text = data?.tanggal
                tvDate.setTextColor(ContextCompat.getColor(root.context, R.color.black))
                btnSave.text = "Edit Laporan"
                reportCategoryAdapter.differ.submitList(categories)
                ivPhoto.setOnClickListener { takeImage() }
            }
        }
    }

    private fun initRecyclerView() {
        binding.apply {
            rvReportCategory.adapter = reportCategoryAdapter
            rvReportCategory.layoutManager = LinearLayoutManager(root.context)
            reportCategoryAdapter.differ.submitList(categories)
            btnSelectCategory.setOnClickListener {
                if (rvReportCategory.visibility == GONE) rvReportCategory.visibility = VISIBLE
                else rvReportCategory.visibility = GONE
            }
            adapterEventHandler()
        }
    }

    private fun adapterEventHandler() {
        binding.apply {
            reportCategoryAdapter.setOnClickListener(object: ReportCategoryAdapter.OnClickListener {
                override fun tapItem(category: String, id: String, binding: CategoryItemBinding) {
                    tvCategory.text = category
                    tvCategory.setTextColor(ContextCompat.getColor(binding.root.context,
                        R.color.black))
                    rvReportCategory.visibility = GONE
                    categoryId = id
                    body["kategori_id"] = RequestBody.create(MultipartBody.FORM, categoryId)
                }
            })
        }
    }

    private fun takeImage() {
        ImagePicker.with(this)
            .compress(300)
            .createIntent { launchResult.launch(it) }
    }

    private var launchResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val dataImage = result.data
        when (result.resultCode) {
            Activity.RESULT_OK -> {
                binding.apply {
                    file = File(dataImage?.data?.path ?: "")
                    ivPhoto.visibility = VISIBLE
                    Glide.with(ivPhoto.context)
                        .load(file)
                        .centerCrop()
                        .into(ivPhoto)
                    btnUpload.visibility = GONE
                }
            }
            ImagePicker.RESULT_ERROR -> {
                Toast.makeText(binding.root.context, ImagePicker.getError(dataImage), Toast.LENGTH_SHORT).show()
            }
            else -> Toast.makeText(binding.root.context, "Picture not taken", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun pickDate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, { _, years, monthOfYear, dayOfMonth ->
            binding.apply {
                val monthFix = if (monthOfYear+1 < 10) {
                    "0${monthOfYear+1}"
                } else "${monthOfYear+1}"
                val dayFix = if (dayOfMonth < 10) {
                    "0$dayOfMonth"
                } else "$dayOfMonth"
                tvDate.text = "$years-$monthFix-$dayFix"
                tanggal = "${tvDate.text}"
                tvDate.setTextColor(ContextCompat.getColor(root.context, R.color.black))
                body["tanggal"] = RequestBody.create(MultipartBody.FORM, tanggal)
            }
        }, year, month, day)
        dpd.show()
    }





    private fun showLoading() = dialog.show()

    private fun hideLoading() = dialog.hide()
}