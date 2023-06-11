package com.kawal.malang.officer.presentation.report.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kawal.malang.officer.data.model.panic.report.PanicCarData
import com.kawal.malang.officer.databinding.PatrolCarItemBinding

class PoliceCarAdapter: RecyclerView.Adapter<PoliceCarAdapter.ViewHolder>() {

    interface PatrolCarClickListener {
        fun tap(binding: PatrolCarItemBinding, position: Int)
    }

    private var patrolCarClickListener: PatrolCarClickListener? = null

    private val callback = object: DiffUtil.ItemCallback<PanicCarData>() {
        override fun areItemsTheSame(oldItem: PanicCarData, newItem: PanicCarData): Boolean =
            oldItem.car == newItem.car

        override fun areContentsTheSame(oldItem: PanicCarData, newItem: PanicCarData): Boolean =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = PatrolCarItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(differ.currentList[position], position)

    override fun getItemCount(): Int = differ.currentList.size

    fun setOnClickListener(patrolCarClickListener: PatrolCarClickListener) {
        this.patrolCarClickListener = patrolCarClickListener
    }

    inner class ViewHolder(val binding: PatrolCarItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PanicCarData, position: Int) {
            binding.apply {
                tvCarNumber.text = data.car?.carNumber
                Glide.with(ivCarPhoto.context)
                    .load(data.car?.user?.photo)
                    .into(ivCarPhoto)
                root.setOnClickListener {
                    patrolCarClickListener?.tap(binding, position)
                }
            }
        }
    }
}