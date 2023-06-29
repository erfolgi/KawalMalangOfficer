package com.kawal.malang.citizen.ui.bantuan

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kawal.malang.citizen.R
import com.kawal.malang.citizen.databinding.ItemBantuanBinding
import com.kawal.malang.citizen.databinding.ItemGiatSmBinding
import com.kawal.malang.citizen.model.response.pengaduan.giat.GiatItem
import com.kawal.malang.citizen.ui.giat.detail.DetailGiatActivity
import com.kawal.malang.citizen.util.AppPreference
import com.kawal.malang.citizen.util.Util
import com.kawal.malang.citizen.util.Util.arise
import com.kawal.malang.citizen.util.Util.begone
import com.kawal.malang.citizen.util.Util.bindIcon

class PresisiAdapter  (private val context: Context, var items: ArrayList<MenuModel>)
    : RecyclerView.Adapter<PresisiAdapter.PresisiHolder>(){
    lateinit var mInflater: LayoutInflater


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresisiHolder {
        mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemRow = mInflater.inflate(R.layout.item_bantuan, parent, false)
        return PresisiHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PresisiHolder, position: Int) {
        holder.bind(items[position],context)
    }

    class PresisiHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding: ItemBantuanBinding = ItemBantuanBinding.bind(itemView)

        fun bind(data: MenuModel, context: Context){
            with(binding) {
                imIcon.bindIcon(context, data.icon)
                txTitle.text=data.title

                if(data.activity==null){
                    txSoon.arise()
                    btBantuan.setOnClickListener {

                    }
                }else{
                    txSoon.begone()
                    btBantuan.setOnClickListener {
                        val intent = Intent(context, data.activity!!::class.java)
                        context.startActivity(intent)
                    }
                }



            }
        }

    }
}