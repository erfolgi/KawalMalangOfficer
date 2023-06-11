package com.kawal.malang.officer.core.util

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PaginationListener : RecyclerView.OnScrollListener() {
    var lManager: LinearLayoutManager? = null
    var isLoading = false
    var load: () -> Unit = {}
    var limit = 20
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount = lManager?.childCount
        val totalItemCount = lManager?.itemCount
        val firstVisibleItemPosition = lManager?.findFirstVisibleItemPosition()
        val hasReachToEnd = firstVisibleItemPosition!! + visibleItemCount!! >= totalItemCount!! && totalItemCount >= limit
        if (!isLoading && hasReachToEnd) {
            load()
        }
    }
}