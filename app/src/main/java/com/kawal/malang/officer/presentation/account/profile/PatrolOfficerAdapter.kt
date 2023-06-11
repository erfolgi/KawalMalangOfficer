package com.kawal.malang.officer.presentation.account.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kawal.malang.officer.data.model.auth.MemberData
import com.kawal.malang.officer.databinding.OfficerSelectorItemBinding

class PatrolOfficerAdapter: RecyclerView.Adapter<PatrolOfficerAdapter.ViewHolder>() {

    interface SelectorTapListener {
        fun tap(binding: OfficerSelectorItemBinding, member: MemberData)
    }

    private var onItemSelected: SelectorTapListener? = null

    private val callback = object: DiffUtil.ItemCallback<MemberData>() {
        override fun areItemsTheSame(oldItem: MemberData, newItem: MemberData): Boolean =
            oldItem.nip == newItem.nip

        override fun areContentsTheSame(oldItem: MemberData, newItem: MemberData): Boolean =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatrolOfficerAdapter.ViewHolder {
        val view = OfficerSelectorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PatrolOfficerAdapter.ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun setOnClickListener(onItemSelected: SelectorTapListener) {
        this.onItemSelected = onItemSelected
    }

    inner class ViewHolder(val binding: OfficerSelectorItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MemberData) {
            binding.apply {
                Glide.with(ivOfficerPhoto.context)
                    .load(data.user?.photo)
                    .into(ivOfficerPhoto)
                tvOfficerName.text = data.user?.name
                root.setOnClickListener { onItemSelected?.tap(this, data) }
            }
        }
    }
}