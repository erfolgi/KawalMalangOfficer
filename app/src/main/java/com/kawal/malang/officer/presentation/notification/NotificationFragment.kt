package com.kawal.malang.officer.presentation.notification

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.PaginationListener
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.notification.NotificationData
import com.kawal.malang.officer.databinding.FragmentNotificationBinding
import com.kawal.malang.officer.presentation.viewmodels.notification.NotificationViewModel
import com.kawal.malang.officer.presentation.viewmodels.notification.NotificationViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NotificationFragment : Fragment() {

    private lateinit var binding: FragmentNotificationBinding
    private lateinit var viewModel: NotificationViewModel
    private lateinit var dialog: Dialog
    private lateinit var paging: PaginationListener

    @Inject
    lateinit var adapter: NotificationAdapter
    @Inject
    lateinit var factory: NotificationViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_notification, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotificationBinding.bind(view)
        /*(requireActivity()).window.statusBarColor = ContextCompat.getColor(
            binding.root.context, R.color.primary_main)*/
        viewModel = ViewModelProvider(requireActivity(), factory)[NotificationViewModel::class.java]
        dialog = AppUtil.loading(requireActivity())
        paging = PaginationListener()

        initRecyclerView()
        getNotification()
        refresh()
    }

    private fun initRecyclerView() {
        binding.apply {
            rvNotification.adapter = adapter
            rvNotification.layoutManager = LinearLayoutManager(binding.root.context)
            paging.lManager = rvNotification.layoutManager as LinearLayoutManager
            paging.load = { paginate() }
            rvNotification.addOnScrollListener(paging)
        }
    }

    private fun getNotification() {
        viewModel.getNotifications()
        viewModel.notifications.observe(viewLifecycleOwner) { res ->
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
                            "Try Again") { getNotification() }
                    }
                }
                is Resource.Success -> {
                    hideLoading()
                    res.data?.let { loadContent(it) }
                    if (binding.swipeRefreshNotification.isRefreshing)
                        binding.swipeRefreshNotification.isRefreshing = false
                }
            }
        }
    }

    private fun refresh() {
        binding.apply {
            swipeRefreshNotification.setOnRefreshListener {
                viewModel.refreshNotifications()
            }
        }
    }

    private fun paginate() {
        viewModel.paginateNotification(adapter.differ.currentList.last().id?.toString() ?: "")
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

    private fun loadContent(list: ArrayList<NotificationData>) {
        binding.apply {
            if (list.isEmpty()) {
                rvNotification.visibility = GONE
                emptyNotification.root.visibility = VISIBLE
            } else {
                emptyNotification.root.visibility = GONE
                adapter.differ.submitList(list)
                rvNotification.visibility = VISIBLE
            }
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