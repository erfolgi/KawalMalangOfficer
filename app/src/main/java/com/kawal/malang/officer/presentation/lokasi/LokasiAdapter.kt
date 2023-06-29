package com.kawal.malang.officer.presentation.lokasi

import android.content.Context
import android.content.Intent
import android.location.Location
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kawal.malang.citizen.model.response.pengaduan.lokasi.LokasiItem
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.bindIcon
import com.kawal.malang.officer.core.util.Util.capitalizeWords
import com.kawal.malang.officer.databinding.ItemLokasiBinding
import java.util.*
import kotlin.collections.ArrayList

class LokasiAdapter (private val context: Context, var items: ArrayList<LokasiItem>)
    : RecyclerView.Adapter<LokasiAdapter.HomeCardHolder>(){
    lateinit var mInflater: LayoutInflater


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardHolder {
        mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemRow = mInflater.inflate(R.layout.item_lokasi, parent, false)
        return HomeCardHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HomeCardHolder, position: Int) {
        holder.bind(items[position],context)
    }

    class HomeCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding: ItemLokasiBinding = ItemLokasiBinding.bind(itemView)

        fun bind(data: LokasiItem, context: Context){
            with(binding){
                imFoto.bindIcon(context,data.foto)
                txCategory.text = data.kategori?.nama?.capitalizeWords() ?: "-"

                txTitle.text= data.nama?.capitalizeWords() ?: "-"
                txDate.text= data.keterangan ?: "-"

                var location = Location("Destination");
                data.latitude.let {
                    if (it != null) {
                        location.latitude= it
                    }
                }
                data.longitude.let {
                    if (it != null) {
                        location.longitude= it
                    }
                }
                Util.wrapLocation(context) { it ->


                    val s = "%.2f".format((it.distanceTo(location)/1000))
                    txDate.text = "$s Km"
                }


                itemView.setOnClickListener {
                    val uri: String =
                        java.lang.String.format(Locale.ENGLISH, "geo:%f,%f", data.latitude, data.longitude)
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                    context.startActivity(intent)
                }
            }
        }

    }
}