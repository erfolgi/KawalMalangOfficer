package com.kawal.malang.officer.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.databinding.StatusItemBinding

class ReportStatusAdapter: RecyclerView.Adapter<ReportStatusAdapter.ViewHolder>() {

    interface OnClickListener {
        fun tapStatus(status: String)
    }

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = StatusItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(AppUtil.reportStatus()[position], position)
    }

    override fun getItemCount(): Int = AppUtil.reportStatus().size

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    private var index: Int? = null

    inner class ViewHolder(private val binding: StatusItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(status: String, pos: Int) {
            binding.apply {
                tvStatus.text = status
                root.setOnClickListener {
                    index = pos
                    notifyDataSetChanged()
                    onClickListener?.tapStatus(status)
                }
                if (index == pos) {
                    tvStatus.setTextColor(
                        ContextCompat.getColor(binding.root.context, R.color.primary_main))
                    tvStatus.background = ContextCompat.getDrawable(binding.root.context,
                        R.drawable.border_selected)
                } else {
                    tvStatus.setTextColor(
                        ContextCompat.getColor(binding.root.context, R.color.grey3))
                    tvStatus.background = ContextCompat.getDrawable(binding.root.context,
                        R.drawable.border_lg)
                }
            }
        }
    }
}