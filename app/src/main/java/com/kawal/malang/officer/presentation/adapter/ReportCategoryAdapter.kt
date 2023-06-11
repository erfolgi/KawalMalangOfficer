package com.kawal.malang.officer.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kawal.malang.officer.data.model.panic.report.CategoryData
import com.kawal.malang.officer.databinding.CategoryItemBinding

class ReportCategoryAdapter: RecyclerView.Adapter<ReportCategoryAdapter.ViewHolder>() {

    interface OnClickListener {
        fun tapItem(category: String, id: String, binding: CategoryItemBinding)
    }

    private var onClickListener: OnClickListener? = null

    private val callback = object: DiffUtil.ItemCallback<CategoryData>() {
        override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    inner class ViewHolder(val binding: CategoryItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CategoryData) {
            binding.apply {
                tvCategory.text = data.name
                root.setOnClickListener {
                    onClickListener?.tapItem("${data.name}", "${data.id}", binding)
                }
            }
        }
    }
}