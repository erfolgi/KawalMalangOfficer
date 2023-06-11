package com.kawal.malang.officer.presentation.briefing.list

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.PaginationListener
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.briefing.BriefingData
import com.kawal.malang.officer.data.model.panic.report.CategoryData
import com.kawal.malang.officer.databinding.BriefingFilterBinding
import com.kawal.malang.officer.databinding.CategoryItemBinding
import com.kawal.malang.officer.databinding.FragmentBriefingListBinding
import com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter
import com.kawal.malang.officer.presentation.briefing.create.CreateBriefingActivity
import com.kawal.malang.officer.presentation.briefing.detail.DetailBriefingActivity
import com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModel
import com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BriefingListFragment : Fragment() {

    private lateinit var binding: FragmentBriefingListBinding
    private lateinit var briefingFilterBinding: BriefingFilterBinding
    private lateinit var bsd: BottomSheetDialog
    private lateinit var viewModel: BriefingViewModel
    private lateinit var dialog: Dialog
    private lateinit var paging: PaginationListener

    @Inject
    lateinit var adapter: BriefingListAdapter
    @Inject
    lateinit var reportCategoryAdapter: ReportCategoryAdapter

    @Inject
    lateinit var viewModelFactory: BriefingViewModelFactory

    private var categoryId = ""
    private var isFiltered = false
    private var title = ""
    private var categories = arrayListOf<CategoryData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_briefing_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBriefingListBinding.bind(view)
        (requireActivity()).window.statusBarColor = ContextCompat.getColor(
            requireActivity(), R.color.primary_main)
        dialog = AppUtil.loading((requireActivity()))
        viewModel = ViewModelProvider(requireActivity(),
            viewModelFactory)[BriefingViewModel::class.java]
        paging = PaginationListener()
        initRecyclerView()
        initFilterDialog()
        refresh()
        binding.etSearch.setEndIconOnClickListener { bsd.show() }
        binding.etSearch.editText?.setOnEditorActionListener { textView, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE) {
                title = "${textView.text}"
                filterBriefingList()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        binding.btnAdd.setOnClickListener {
            val i = Intent(requireActivity(), CreateBriefingActivity::class.java)
            i.putExtra(CreateBriefingActivity.CATEGORY, categories)
            i.putExtra(CreateBriefingActivity.IS_EDIT, false)
            requireActivity().startActivity(i)
        }
    }

    override fun onResume() {
        super.onResume()
        getCategories()
        getBriefingList()
    }

    private fun initRecyclerView() {
        binding.apply {
            rvReportList.adapter = adapter
            rvReportList.layoutManager = LinearLayoutManager(requireActivity())
            paging.lManager = rvReportList.layoutManager as LinearLayoutManager
            paging.load = { paginate() }
            rvReportList.addOnScrollListener(paging)
        }
    }

    private fun initFilterDialog() {
        val inflater = LayoutInflater.from((requireActivity()))
        briefingFilterBinding = BriefingFilterBinding.inflate(inflater)
        bsd = BottomSheetDialog((requireActivity()), R.style.BottomSheetDialog)
        bsd.setContentView(briefingFilterBinding.root)

        briefingFilterBinding.apply {
            rvReportCategory.adapter = reportCategoryAdapter
            rvReportCategory.layoutManager = LinearLayoutManager((requireActivity()))
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
                    || tvDate.text != "Tanggal") {
                    filterBriefingList()
                    bsd.dismiss()
                } else Toast.makeText(root.context, "Pilih kategori atau rentang tanggal",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getBriefingList() {
        viewModel.getBriefingList()
        viewModel.briefingData.observe(viewLifecycleOwner) { res ->
            when(res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar((requireActivity()), it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction((requireActivity()), it, "Try Again") {
                            getBriefingList()
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
        viewModel.getBriefingCategory()
        viewModel.categories.observe(viewLifecycleOwner) { res ->
            when(res) {
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar((requireActivity()), it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction((requireActivity()), it, "Try Again") {
                            getCategories()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let {
                        categories = it
                        loadCategories(it)
                    }
                }
                else -> {}
            }
        }
    }

    private fun filterBriefingList() {
        viewModel.filterBriefingList("", categoryId, "", title)
        viewModel.briefingData.observe(viewLifecycleOwner) { res ->
            when(res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar((requireActivity()), it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction((requireActivity()), it, "Try Again") {
                            filterBriefingList()
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
            swipeRefresh.setOnRefreshListener {
                viewModel.refreshBriefingList()
                viewModel.briefingData.observe(viewLifecycleOwner) { res ->
                    when(res) {
                        is Resource.Loading -> showLoading()
                        is Resource.Error -> {
                            hideLoading()
                            res.message?.let { AppUtil.snackBar((requireActivity()), it) }
                        }
                        is Resource.NetworkError -> {
                            hideLoading()
                            res.message?.let {
                                AppUtil.snackBarAction((requireActivity()), it,
                                    "Try Again") { getBriefingList() }
                            }
                        }
                        is Resource.Success -> {
                            hideLoading()
                            categoryId = ""
                            title = ""
                            isFiltered = false
                            res.data?.let { loadReportContent(it) }
                        }
                    }
                }
                swipeRefresh.isRefreshing = false
            }
        }
    }

    private fun paginate() {
        viewModel.paginateBriefingList(
            "${adapter.differ.currentList.last().id}",
            categoryId,
            title
        )
        viewModel.paginate.observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar((requireActivity()), it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction((requireActivity()), it,
                            "Try Again") { paginate() }
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


    private fun adapterEventHandler(binding: BriefingFilterBinding) {
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


    private fun loadReportContent(list: ArrayList<BriefingData>) {
        binding.apply {
            if (list.isEmpty()) {
                rvReportList.visibility = View.GONE
                emptyPanic.root.visibility = View.VISIBLE
            } else {
                emptyPanic.root.visibility = View.GONE
                adapter.differ.submitList(list)
                rvReportList.visibility = View.VISIBLE
                adapter.setOnClickListener(object : BriefingListAdapter.OnItemClickListener {
                    override fun tap() {
                        val i = Intent(root.context, DetailBriefingActivity::class.java)
                        i.putExtra(DetailBriefingActivity.CATEGORIES, categories)
                        root.context.startActivity(i)
                    }

                })
            }
        }
    }

    private fun loadCategories(list: ArrayList<CategoryData>) {
        reportCategoryAdapter.differ.submitList(list)
    }

    @SuppressLint("SetTextI18n")
    private fun filterDismissed(binding: BriefingFilterBinding) {
        binding.apply {
            tvCategory.text = "Pilih kategori laporan"
            tvCategory.setTextColor(ContextCompat.getColor(root.context, R.color.grey))
            tvDate.text = "Tanggal"
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