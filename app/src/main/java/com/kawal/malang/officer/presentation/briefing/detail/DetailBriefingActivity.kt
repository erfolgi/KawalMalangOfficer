package com.kawal.malang.officer.presentation.briefing.detail

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.briefing.BriefingData
import com.kawal.malang.officer.data.model.panic.report.CategoryData
import com.kawal.malang.officer.databinding.ActivityDetailBriefingBinding
import com.kawal.malang.officer.databinding.ConfirmDialogBinding
import com.kawal.malang.officer.presentation.briefing.create.CreateBriefingActivity
import com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModel
import com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailBriefingActivity : AppCompatActivity() {

    companion object {
        const val CATEGORIES = "CATEGORIES"
    }

    private lateinit var binding : ActivityDetailBriefingBinding
    private lateinit var confirmBinding: ConfirmDialogBinding
    private lateinit var preference: AppPreference
    private lateinit var viewModel: BriefingViewModel
    private lateinit var dialog: Dialog
    private lateinit var confirmDialog: Dialog

    @Inject
    lateinit var factory: BriefingViewModelFactory

    private var data: BriefingData? = null
    private var categories: ArrayList<CategoryData>? = arrayListOf()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBriefingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preference = AppPreference(this)
        viewModel = ViewModelProvider(this, factory)[BriefingViewModel::class.java]
        dialog = AppUtil.loading(this)
        categories = intent.getParcelableArrayListExtra(CATEGORIES)
        binding.apply {
            baseLayout.setOnClickListener { cvMenu.visibility = GONE }
        }

        with(binding){
            window.statusBarColor = ContextCompat.getColor(root.context, android.R.color.transparent)
            toolbar.tbBack.setOnClickListener { finish() }
            toolbar.tbTitle.text = "Detail Laporan"
            toolbar.tbMore.setOnClickListener {
                if (cvMenu.visibility == VISIBLE) cvMenu.visibility = GONE
                else cvMenu.visibility = VISIBLE
            }
            menuDelete.setOnClickListener { confirmDialog.show() }
            menuEdit.setOnClickListener {
                val i = Intent(root.context, CreateBriefingActivity::class.java)
                i.putExtra(CreateBriefingActivity.CATEGORY, categories)
                    .putExtra(CreateBriefingActivity.DATA, data)
                    .putExtra(CreateBriefingActivity.IS_EDIT, true)
                root.context.startActivity(i)

                cvMenu.visibility = GONE
            }
        }

        initConfirmDialog()
    }

    override fun onResume() {
        super.onResume()
        val dataX = preference.getStoredBriefing()
        if(dataX.id!=null){
            this.data = dataX
        }
        bind()
        refresh()
    }

    private fun bind(){
        binding.apply {
            txName.text = data?.anggota?.user?.name
            txDate.text = data?.tanggal
            txCategory.text = data?.kategori?.nama
            txTitle.text= data?.judul
            txDesc.text = data?.deskripsi
            txLocation.text = data?.lokasi
            Glide.with(this@DetailBriefingActivity)
                .load(data?.anggota?.user?.foto)
                .into(ivReporter)
            Glide.with(this@DetailBriefingActivity)
                .load(data?.foto)
                .into(ivImage)
        }
    }

    private fun initConfirmDialog() {
        confirmDialog = Dialog(this)
        confirmDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val inflater = LayoutInflater.from(this)
        confirmBinding = ConfirmDialogBinding.inflate(inflater)
        confirmDialog.setContentView(confirmBinding.root)
        confirmBinding.apply {
            tvNo.setOnClickListener { confirmDialog.dismiss() }
            tvYes.setOnClickListener {
                confirmDialog.dismiss()
                deleteBriefing()
            }
        }
    }

    private fun refresh() {
        viewModel.getDetailBriefing("${data?.id}")
        viewModel.detail.observe(this) { res ->
            when (res) {
                is Resource.Error -> {
                    res.message?.let { AppUtil.snackBar(this, it) }
                }
                is Resource.NetworkError -> {
                    res.message?.let {
                        AppUtil.snackBarAction(this, it, "Try Again") {
                            refresh()
                        }
                    }
                }
                is Resource.Success -> {
                    res.data?.let {
                        data = it
                        bind()
                    }
                }
                else -> {}
            }
        }
    }

    private fun deleteBriefing() {
        viewModel.deleteBriefing("${data?.id}")
        viewModel.postData.observe(this) { res ->
            when (res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar(this, it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction(this, it, "Try Again") {
                            deleteBriefing()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            }
        }
    }

    private fun showLoading() = dialog.show()

    private fun hideLoading() = dialog.hide()

}