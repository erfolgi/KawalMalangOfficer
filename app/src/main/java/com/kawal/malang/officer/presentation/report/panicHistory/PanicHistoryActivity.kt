package com.kawal.malang.officer.presentation.report.panicHistory

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.PaginationListener
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.panic.report.CategoryData
import com.kawal.malang.officer.data.model.panic.report.PanicReportData
import com.kawal.malang.officer.databinding.ActivityPanicHistoryBinding
import com.kawal.malang.officer.databinding.CategoryItemBinding
import com.kawal.malang.officer.databinding.PanicFilterBinding
import com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter
import com.kawal.malang.officer.presentation.report.list.ReportListAdapter
import com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModel
import com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PanicHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPanicHistoryBinding
    private lateinit var panicFilterBinding: PanicFilterBinding
    private lateinit var bsd: BottomSheetDialog
    private lateinit var viewModel: PanicViewModel
    private lateinit var dialog: Dialog
    private lateinit var paging: PaginationListener

    @Inject
    lateinit var adapter: ReportListAdapter
    @Inject
    lateinit var reportCategoryAdapter: ReportCategoryAdapter
    @Inject
    lateinit var viewModelFactory: PanicViewModelFactory

    private var categoryId = ""
    private var isFiltered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPanicHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.primary_main)
        dialog = AppUtil.loading(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[PanicViewModel::class.java]
        paging = PaginationListener()

        getCategories()
        initRecyclerView()
        initFilterDialog()
        refresh()
        binding.btnFilter.setOnClickListener { bsd.show() }
        binding.btnBack.setOnClickListener { finish() }
    }

    override fun onResume() {
        super.onResume()
        getPanicReport()
    }

    private fun initRecyclerView() {
        binding.apply {
            rvReportList.adapter = adapter
            rvReportList.layoutManager = LinearLayoutManager(root.context)
            paging.lManager = rvReportList.layoutManager as LinearLayoutManager
            paging.load = { paginate() }
            rvReportList.addOnScrollListener(paging)
        }
    }

    private fun initFilterDialog() {
        val inflater = LayoutInflater.from(this)
        panicFilterBinding = PanicFilterBinding.inflate(inflater)
        bsd = BottomSheetDialog(this, R.style.BottomSheetDialog)
        bsd.setContentView(panicFilterBinding.root)

        panicFilterBinding.apply {
            rvReportCategory.adapter = reportCategoryAdapter
            rvReportCategory.layoutManager = LinearLayoutManager(root.context)
            ivClose.setOnClickListener {
                filterDismissed(this)
                bsd.dismiss()
            }
            bsd.setOnDismissListener { filterDismissed(this) }
            btnSelectCategory.setOnClickListener {
                if (rvReportCategory.visibility == View.GONE) rvReportCategory.visibility =
                    View.VISIBLE
                else rvReportCategory.visibility = View.GONE
            }
            adapterEventHandler(this)
            btnApply.setOnClickListener {
                if (tvCategory.text != "Pilih kategori laporan"
                    || tvStartDate.text != "Tanggal Awal" || tvEndDate.text != "Tanggal Akhir") {
                    filterPanicReport()
                    bsd.dismiss()
                } else Toast.makeText(root.context, "Pilih kategori atau rentang tanggal",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getPanicReport() {
        viewModel.getPanicReport()
        viewModel.panicReportData.observe(this) { res ->
            when(res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar(this, it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction(this, it, "Try Again") {
                            getPanicReport()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let { loadReportContent(it) }
                }
            }
        }
    }

    private fun getCategories() {
        viewModel.getPanicCategory()
        viewModel.categories.observe(this) { res ->
            when(res) {
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar(this, it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction(this, it, "Try Again") {
                            getPanicReport()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let { loadCategories(it) }
                }
                else -> {}
            }
        }
    }

    private fun filterPanicReport() {
        viewModel.filterPanicReport(categoryId)
        viewModel.panicReportData.observe(this) { res ->
            when(res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar(this, it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction(this, it, "Try Again") {
                            filterPanicReport()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let { loadReportContent(it) }
                }
            }
        }
    }

    private fun refresh() {
        binding.apply {
            swipeRefreshPanicReport.setOnRefreshListener {
                viewModel.refreshPanicReport()
                viewModel.panicReportData.observe(this@PanicHistoryActivity) { res ->
                    when(res) {
                        is Resource.Loading -> showLoading()
                        is Resource.Error -> {
                            hideLoading()
                            res.message?.let { AppUtil.snackBar(this@PanicHistoryActivity, it) }
                        }
                        is Resource.NetworkError -> {
                            hideLoading()
                            res.message?.let {
                                AppUtil.snackBarAction(this@PanicHistoryActivity, it,
                                    "Try Again") { getPanicReport() }
                            }
                        }
                        is Resource.Success -> {
                            hideLoading()
                            categoryId = ""
                            res.data?.let { loadReportContent(it) }
                        }
                    }
                }
                swipeRefreshPanicReport.isRefreshing = false
            }
        }
    }

    private fun paginate() {
        viewModel.paginatePanicReport(categoryId, "${adapter.differ.currentList.last().id}")
        viewModel.paginate.observe(this) { res ->
            when (res) {
                is Resource.Loading -> {
                    showLoading()
                }
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar(this, it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction(this, it, "Try Again") { paginate() }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let {
                        if (it.isNotEmpty()) {
                            paging.limit+it.size
                            adapter.differ.submitList(it)
                        }
                    }
                }
            }
        }
    }

    private fun adapterEventHandler(binding: PanicFilterBinding) {
        binding.apply {
            reportCategoryAdapter.setOnClickListener(object: ReportCategoryAdapter.OnClickListener {
                override fun tapItem(category: String, id: String, binding: CategoryItemBinding) {
                    tvCategory.text = category
                    tvCategory.setTextColor(ContextCompat.getColor(binding.root.context,
                        R.color.black))
                    rvReportCategory.visibility = View.GONE
                    categoryId = id
                    isFiltered = true
                }
            })
        }
    }

    private fun loadReportContent(list: ArrayList<PanicReportData>) {
        binding.apply {
            if (list.isEmpty()) {
                rvReportList.visibility = View.GONE
                if (!isFiltered) {
                    emptyPanic.root.visibility = View.VISIBLE
                    emptyPanicFiltered.root.visibility = View.GONE
                } else {
                    emptyPanic.root.visibility = View.GONE
                    emptyPanicFiltered.root.visibility = View.VISIBLE
                }
            } else {
                emptyPanic.root.visibility = View.GONE
                emptyPanicFiltered.root.visibility = View.GONE
                adapter.differ.submitList(list.toList())
                rvReportList.visibility = View.VISIBLE
            }
        }
    }

    private fun loadCategories(list: ArrayList<CategoryData>) {
        reportCategoryAdapter.differ.submitList(list)
    }

    @SuppressLint("SetTextI18n")
    private fun filterDismissed(binding: PanicFilterBinding) {
        binding.apply {
            tvCategory.text = "Pilih kategori laporan"
            tvCategory.setTextColor(ContextCompat.getColor(root.context, R.color.grey))
            tvStartDate.text = "Tanggal Awal"
            tvEndDate.text = "Tanggal Akhir"
            rvReportCategory.visibility = View.GONE
        }
    }

    private fun showLoading() {
        paging.isLoading = true
        dialog.show()
    }

    private fun hideLoading() {
        paging.isLoading = false
        dialog.dismiss()
    }
}