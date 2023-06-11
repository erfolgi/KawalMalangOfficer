package com.kawal.malang.officer.presentation.patrol.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.data.model.panic.report.PatrolData
import com.kawal.malang.officer.databinding.PatrolHistoryItemBinding

class PatrolHistoryAdapter: RecyclerView.Adapter<PatrolHistoryAdapter.ViewHolder>() {

    interface InitOfficerAdapterListener {
        fun init(binding: PatrolHistoryItemBinding, data: PatrolData)
    }

    private var listener: InitOfficerAdapterListener? = null

    private val callback = object: DiffUtil.ItemCallback<PatrolData>() {
        override fun areItemsTheSame(oldItem: PatrolData, newItem: PatrolData): Boolean =
            oldItem.distance == newItem.distance

        override fun areContentsTheSame(oldItem: PatrolData, newItem: PatrolData): Boolean =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = PatrolHistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun initOfficerAdapter(listener: InitOfficerAdapterListener) {
        this.listener = listener
    }

    inner class ViewHolder(val binding: PatrolHistoryItemBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data: PatrolData) {
            binding.apply {
                tvDate.text = AppUtil.convertDateTime(data.updatedAt)
                tvStartTime.text = if (data.startTime != null) {
                    AppUtil.convertToTime(data.startTime)
                } else "-"
                tvEndTime.text = if (data.endTime != null) {
                    AppUtil.convertToTime(data.endTime)
                } else "-"
                tvDistance.text = "${data.distance ?: "0"} km"
                tvDescription.text = data.desc ?: "-"
                listener?.init(this, data)
            }
        }
    }
}