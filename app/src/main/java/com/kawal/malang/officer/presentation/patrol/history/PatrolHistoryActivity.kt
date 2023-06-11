package com.kawal.malang.officer.presentation.patrol.history

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.panic.report.PatrolData
import com.kawal.malang.officer.databinding.ActivityPatrolHistoryBinding
import com.kawal.malang.officer.databinding.PatrolHistoryItemBinding
import com.kawal.malang.officer.presentation.panicevent.PanicOfficerAdapter
import com.kawal.malang.officer.presentation.viewmodels.patrol.PatrolViewModel
import com.kawal.malang.officer.presentation.viewmodels.patrol.PatrolViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PatrolHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPatrolHistoryBinding
    private lateinit var viewModel: PatrolViewModel
    private lateinit var dialog: Dialog

    @Inject
    lateinit var factory: PatrolViewModelFactory
    @Inject
    lateinit var patrolAdapter: PatrolHistoryAdapter
    @Inject
    lateinit var officerAdapter: PanicOfficerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatrolHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, factory)[PatrolViewModel::class.java]
        dialog = AppUtil.loading(this)

        initAppBar()
        initRecyclerView()
        getPatrolHistory()
        refresh()
    }

    @SuppressLint("SetTextI18n")
    private fun initAppBar() {
        this.window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        binding.appbar.apply {
            tbBack.setOnClickListener { finish() }
            tbTitle.text = "Riwayat Patroli"
        }
    }

    private fun initRecyclerView() {
        binding.apply {
            rvPatrolHistory.adapter = patrolAdapter
            rvPatrolHistory.layoutManager = LinearLayoutManager(root.context)
        }
    }

    private fun getPatrolHistory() {
        viewModel.getPatrolHistory()
        viewModel.history.observe(this) { res ->
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
                            getPatrolHistory()
                        }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let { loadContent(it) }
                }
            }
        }
    }

    private fun refresh() {
        val activity = this
        binding.apply {
            swipeRefreshPatrolHistory.setOnRefreshListener {
                viewModel.refreshPatrolHistory()
                viewModel.history.observe(activity) { res ->
                    when (res) {
                        is Resource.Error -> {
                            res.message?.let { AppUtil.snackBar(activity, it) }
                        }
                        is Resource.NetworkError -> {
                            res.message?.let {
                                AppUtil.snackBarAction(activity, it, "Try Again") {
                                    refresh()
                                }
                            }
                        }
                        is Resource.Success -> {
                            res.data?.let { loadContent(it) }
                            swipeRefreshPatrolHistory.isRefreshing = false
                        }
                        else -> {}
                    }
                }
            }
        }
    }

    private fun loadContent(list: ArrayList<PatrolData>) {
        binding.apply {
            if (list.isEmpty()) {
                emptyPanicHistory.visibility = VISIBLE
                rvPatrolHistory.visibility = GONE
            } else {
                emptyPanicHistory.visibility = GONE
                patrolAdapter.differ.submitList(list)
                rvPatrolHistory.visibility = VISIBLE
                patrolAdapter.initOfficerAdapter(object: PatrolHistoryAdapter.InitOfficerAdapterListener {
                    override fun init(binding: PatrolHistoryItemBinding, data: PatrolData) {
                        binding.apply {
                            officerAdapter.differ.submitList(data.member)
                            rvOfficer.adapter = officerAdapter
                            rvOfficer.layoutManager = LinearLayoutManager(root.context)
                        }
                    }
                })
            }
        }
    }

    private fun showLoading() = dialog.show()

    private fun hideLoading() = dialog.dismiss()

}