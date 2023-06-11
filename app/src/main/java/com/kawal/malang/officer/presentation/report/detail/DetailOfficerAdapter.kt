package com.kawal.malang.officer.presentation.report.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kawal.malang.officer.data.model.auth.MemberData
import com.kawal.malang.officer.databinding.PatrolOfficerItemBinding

class DetailOfficerAdapter: RecyclerView.Adapter<DetailOfficerAdapter.ViewHolder>() {

    private val callback = object: DiffUtil.ItemCallback<MemberData>() {
        override fun areItemsTheSame(oldItem: MemberData, newItem: MemberData): Boolean =
            oldItem.nip == newItem.nip

        override fun areContentsTheSame(oldItem: MemberData, newItem: MemberData): Boolean =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = PatrolOfficerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(differ.currentList[position])

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(val binding: PatrolOfficerItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MemberData) {
            binding.apply {
                tvOfficerName.text = data.user?.name
                Glide.with(ivOfficerPhoto.context)
                    .load(data.user?.photo)
                    .into(ivOfficerPhoto)
            }
        }
    }
}