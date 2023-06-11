package com.kawal.malang.officer.presentation.panicevent

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.data.model.panic.report.TimelineData
import com.kawal.malang.officer.databinding.TimelineItemBinding

class TimelineAdapter: RecyclerView.Adapter<TimelineAdapter.ViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<TimelineData>() {
        override fun areItemsTheSame(oldItem: TimelineData, newItem: TimelineData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TimelineData, newItem: TimelineData): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = TimelineItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position], position)
    }

    override fun getItemCount(): Int  = differ.currentList.size

    inner class ViewHolder(private val binding: TimelineItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TimelineData, pos: Int) {
            binding.apply {
                tvDate.text = AppUtil.convertDateTime(data.createdAt)
                tvDesc.text = data.desc
                if (pos == 0) {
                    if (pos == differ.currentList.size-1) {
                        line.visibility = GONE
                    } else {
                        line.visibility = VISIBLE
                    }
                    status.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.primary_main))
                } else {
                    if (pos == differ.currentList.size-1) {
                        line.visibility = GONE
                    } else {
                        line.visibility = VISIBLE
                    }
                    status.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.grey3))
                }
            }
        }
    }
}