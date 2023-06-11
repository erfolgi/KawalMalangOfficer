package com.kawal.malang.officer.presentation.notification

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.data.model.notification.NotificationData
import com.kawal.malang.officer.databinding.NotificationItemBinding

class NotificationAdapter: RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    private val callback = object: DiffUtil.ItemCallback<NotificationData>() {
        override fun areItemsTheSame(
            oldItem: NotificationData,
            newItem: NotificationData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NotificationData,
            newItem: NotificationData
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = NotificationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(val binding: NotificationItemBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data: NotificationData) {
            binding.apply {
                tvDate.text = AppUtil.convertDateTime(data.createdAt)
                tvTitle.text = data.title
                tvDescription.text = data.content
            }
        }
    }
}