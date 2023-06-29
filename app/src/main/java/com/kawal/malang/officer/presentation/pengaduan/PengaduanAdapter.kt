package com.kawal.malang.officer.presentation.pengaduan

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil.setStatus
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.capitalizeWords
import com.kawal.malang.officer.data.model.pengaduan.PengaduanItem
import com.kawal.malang.officer.databinding.ItemPengaduanBinding
import com.kawal.malang.officer.presentation.pengaduan.detail.DetailPengaduanActivity

class PengaduanAdapter (private val context: Context, var items: ArrayList<PengaduanItem>)
    : RecyclerView.Adapter<PengaduanAdapter.HomeCardHolder>(){
    lateinit var mInflater: LayoutInflater


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardHolder {
        mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemRow = mInflater.inflate(R.layout.item_pengaduan, parent, false)
        return HomeCardHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HomeCardHolder, position: Int) {
        holder.bind(items[position],context)
    }

    class HomeCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding: ItemPengaduanBinding = ItemPengaduanBinding.bind(itemView)

        fun bind(data: PengaduanItem, context: Context){
            with(binding){

                txTitle.text = data.judul ?: "-"
                txKategori.text = data.kategori?.nama?.capitalizeWords() ?: "-"
                txSubkategori.text = data.subKategori?.nama?.capitalizeWords() ?: "-"

                txStatus.setStatus(context, data.status)
                txDate.text= Util.showFullDate(data.tanggal ?: "-")


                itemView.setOnClickListener {
                    val preference = AppPreference(context)
                    preference.setStoredPengaduan(data)
                    val intent = Intent(context, DetailPengaduanActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }

    }
}