package com.kawal.malang.officer.presentation.briefing.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.data.model.briefing.BriefingData
import com.kawal.malang.officer.databinding.BriefingItemBinding

class BriefingListAdapter: RecyclerView.Adapter<BriefingListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun tap()
    }

    private var itemClickListener: OnItemClickListener? = null

    private val callback = object: DiffUtil.ItemCallback<BriefingData>() {
        override fun areItemsTheSame(oldItem: BriefingData, newItem: BriefingData): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: BriefingData,
            newItem: BriefingData
        ): Boolean = oldItem == newItem

    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = BriefingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun setOnClickListener(listener: OnItemClickListener) {
        this.itemClickListener = listener
    }

    inner class ViewHolder(val binding: BriefingItemBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data: BriefingData) {
            binding.apply {
                tvCategory.text = data.kategori?.nama ?: "-"
                tvDate.text = AppUtil.convertDateTime(data.createdAt ?: "2022-01-01")
                tvDescription.text = data.deskripsi
                tvName.text = data.anggota?.user?.name ?: "-"
                tvReportTitle.text = data.judul
                Glide.with(ivReporter.context)
                    .load(data.anggota?.user?.foto)
                    .into(ivReporter)
                ivReporter

                root.setOnClickListener {
                    AppPreference(root.context).setStoredBriefing(data)
                    itemClickListener?.tap()
                }
            }
        }
    }
}