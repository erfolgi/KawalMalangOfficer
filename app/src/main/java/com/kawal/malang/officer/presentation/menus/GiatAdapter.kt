package com.kawal.malang.officer.ui.bottomnav.ui.pengaduan

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.bindIcon
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem
import com.kawal.malang.officer.databinding.ItemGiatSmBinding
import com.kawal.malang.officer.presentation.giat.detail.DetailGiatActivity


class GiatAdapter (private val context: Context, var items: ArrayList<GiatItem>)
    : RecyclerView.Adapter<GiatAdapter.GiatCardHolder>(){
    lateinit var mInflater: LayoutInflater


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiatCardHolder {
        mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemRow = mInflater.inflate(R.layout.item_giat_sm, parent, false)
        return GiatCardHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GiatCardHolder, position: Int) {
        holder.bind(items[position],context)
    }

    class GiatCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding: ItemGiatSmBinding = ItemGiatSmBinding.bind(itemView)

        fun bind(data: GiatItem, context: Context){
            with(binding) {
                txTitle.text = data.judul
                imFoto.bindIcon(context, data.foto)
//                txDate.text = Util.showFullDate(data.createdAt)
                txDate.text = Util.showFullDate(data.deskripsi)
                btIntent.setOnClickListener {
                    val preference = AppPreference(context)
                    preference.setStoredGiat(data)
                    val intent = Intent(context, DetailGiatActivity::class.java)
                    context.startActivity(intent)
                }




            }
        }

    }
}