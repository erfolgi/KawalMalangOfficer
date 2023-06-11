package com.kawal.malang.officer.presentation.report.list

import android.Manifest
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.panic.report.PanicReportData
import com.kawal.malang.officer.databinding.FragmentReportListBinding
import com.kawal.malang.officer.presentation.DashboardActivity
import com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModel
import com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ReportListFragment : Fragment() {

    private lateinit var binding: FragmentReportListBinding
    private lateinit var viewModel: PanicViewModel
    private lateinit var dialog: Dialog
    private lateinit var askPermission: ActivityResultLauncher<Array<String>>

    @Inject
    lateinit var adapter: ReportListAdapter
    @Inject
    lateinit var viewModelFactory: PanicViewModelFactory

    private var categoryId = ""
    private var isFiltered = false
    private var lat = 0.0
    private var lng = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report_list, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReportListBinding.bind(view)
        /*(activity as DashboardActivity).window.statusBarColor = ContextCompat.getColor(
            requireActivity(), R.color.primary_main)*/
        dialog = AppUtil.loading((activity as DashboardActivity))
        viewModel = ViewModelProvider((activity as DashboardActivity),
            viewModelFactory)[PanicViewModel::class.java]
        initRecyclerView()
        setUpPermission()
        refresh()
    }

    override fun onResume() {
        super.onResume()
        if (view != null) getPanicReport()
    }

    private fun initRecyclerView() {
        binding.apply {
            rvReportList.adapter = adapter
            rvReportList.layoutManager = LinearLayoutManager(root.context)
        }
    }

    private fun getPanicReport() {
        viewModel.getAroundPanic(lat, lng)
        viewModel.panicReportData.observe(viewLifecycleOwner) { res ->
            when(res) {
                is Resource.Loading -> showLoading()
                is Resource.Error -> {
                    hideLoading()
                    res.message?.let { AppUtil.snackBar((activity as DashboardActivity), it) }
                }
                is Resource.NetworkError -> {
                    hideLoading()
                    res.message?.let {
                        AppUtil.snackBarAction((activity as DashboardActivity), it, "Try Again") {
                            setUpPermission()
                        }
                    }
                }
                is Resource.Success -> {
                    res.data?.let { loadReportContent(it) }
                    hideLoading()
                }
            }
        }
    }

    private fun refresh() {
        binding.apply {
            swipeRefreshPanicReport.setOnRefreshListener {
                viewModel.refreshAroundPanic(lat, lng)
                viewModel.panicReportData.observe(viewLifecycleOwner) { res ->
                    when(res) {
                        is Resource.Loading -> showLoading()
                        is Resource.Error -> {
                            hideLoading()
                            res.message?.let { AppUtil.snackBar((activity as DashboardActivity), it) }
                        }
                        is Resource.NetworkError -> {
                            hideLoading()
                            res.message?.let {
                                AppUtil.snackBarAction((activity as DashboardActivity), it,
                                    "Try Again") { refresh() }
                            }
                        }
                        is Resource.Success -> {
                            categoryId = ""
                            res.data?.let { loadReportContent(it) }
                            hideLoading()
                        }
                    }
                }
                swipeRefreshPanicReport.isRefreshing = false
            }
        }
    }

    private fun loadReportContent(list: ArrayList<PanicReportData>) {
        binding.apply {
            if (list.isEmpty()) {
                rvReportList.visibility = GONE
                if (!isFiltered) {
                    emptyPanic.root.visibility = VISIBLE
                    emptyPanicFiltered.root.visibility = GONE
                } else {
                    emptyPanic.root.visibility = GONE
                    emptyPanicFiltered.root.visibility = VISIBLE
                }
            } else {
                emptyPanic.root.visibility = GONE
                emptyPanicFiltered.root.visibility = GONE
                adapter.differ.submitList(list.toList())
                rvReportList.visibility = VISIBLE
            }
        }
    }

    private fun requestLocation() {
        AppUtil.getLastLocation(
            (activity as DashboardActivity), { latitude, longitude ->
                lat = latitude
                lng = longitude
                if (view != null) getPanicReport()
            }, { askPermission }
        )
    }

    private fun setUpPermission() {
        askPermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            var allGranted = true
            for (granted in it.values) {
                allGranted = allGranted && granted
            }

            if (allGranted) requestLocation()
        }
        askPermission.launch(arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        ))
    }

    private fun showLoading() {
        dialog.show()
    }

    private fun hideLoading() {
        dialog.dismiss()
    }
}