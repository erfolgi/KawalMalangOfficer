package com.kawal.malang.officer.presentation.report.list

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.data.model.panic.report.PanicReportData
import com.kawal.malang.officer.databinding.ReportItemBinding
import com.kawal.malang.officer.presentation.report.detail.DetailReportActivity

class ReportListAdapter: RecyclerView.Adapter<ReportListAdapter.ViewHolder>() {

    private val callback = object: DiffUtil.ItemCallback<PanicReportData>() {
        override fun areItemsTheSame(oldItem: PanicReportData, newItem: PanicReportData): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: PanicReportData,
            newItem: PanicReportData
        ): Boolean = oldItem == newItem

    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ReportItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ReportItemBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data: PanicReportData) {
            binding.apply {
                Glide.with(ivReporter.context)
                    .load(data.reporter?.photo)
                    .into(ivReporter)
                Glide.with(ivCategory.context)
                    .load(data.category?.icon)
                    .into(ivCategory)
                tvReporterName.text = data.reporter?.name
                tvStatus.text = data.status
                tvDate.text = AppUtil.convertDateTime(data.createdAt ?: "2022-01-01")
                tvPlace.text = AppUtil.reverseGeocode(
                    data.latitude ?: 0.0,
                    data.longitude ?: 0.0,
                    tvPlace.context
                )
                tvCategory.text = data.category?.name
                root.setOnClickListener {
                    val i = Intent(root.context, DetailReportActivity::class.java)
                    i.putExtra(DetailReportActivity.DETAIL_DATA, data)
                    root.context.startActivity(i)
                }
            }
        }
    }
}