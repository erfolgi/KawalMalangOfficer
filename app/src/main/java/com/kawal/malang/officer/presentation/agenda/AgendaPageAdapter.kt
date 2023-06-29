package com.kawal.malang.officer.presentation.agenda

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kawal.malang.citizen.model.response.pengaduan.agenda.AgendaItem
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.bindIcon
import com.kawal.malang.officer.databinding.ItemAgendaBinding
import com.kawal.malang.officer.presentation.agenda.detail.DetailAgendaActivity

class AgendaPageAdapter (private val context: Context, var items: ArrayList<AgendaItem>)
    : RecyclerView.Adapter<AgendaPageAdapter.AgendaCardHolder>(){
    lateinit var mInflater: LayoutInflater


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendaCardHolder {
        mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemRow = mInflater.inflate(R.layout.item_agenda, parent, false)
        return AgendaCardHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AgendaCardHolder, position: Int) {
        holder.bind(items[position],context)
    }

    class AgendaCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding: ItemAgendaBinding = ItemAgendaBinding.bind(itemView)

        fun bind(data: AgendaItem, context: Context){
            with(binding) {
                txTitle.text = data.judul
                imFoto.bindIcon(context, data.foto)
//                txDate.text = Util.showFullDate(data.createdAt)
                txDate.text = Util.showFullDate(data.deskripsi)
                btIntent.setOnClickListener {
                    val preference = AppPreference(context)
                    preference.setStoredAgenda(data)
                    val intent = Intent(context, DetailAgendaActivity::class.java)
                    context.startActivity(intent)
                }



            }
        }

    }
}