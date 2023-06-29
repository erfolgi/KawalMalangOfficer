package com.kawal.malang.officer.presentation.giat.detail.komentar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.recyclerview.widget.RecyclerView

import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.bindIcon
import com.kawal.malang.officer.data.model.pengaduan.giat.KomentarItem
import com.kawal.malang.officer.databinding.ItemCommentBinding
import com.kawal.malang.officer.databinding.PopupCommentBinding

class KomentarAdapter  (private val context: Context, var items: ArrayList<KomentarItem?>, val presenter: KomentarPresenter)
    : RecyclerView.Adapter<KomentarAdapter.KomentarCardHolder>(){
    lateinit var mInflater: LayoutInflater


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KomentarCardHolder {
        mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemRow = mInflater.inflate(R.layout.item_comment, parent, false)
        return KomentarCardHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: KomentarCardHolder, position: Int) {
        items[position]?.let { holder.bind(it,context, presenter) }
    }

    class KomentarCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding: ItemCommentBinding = ItemCommentBinding.bind(itemView)
        lateinit var menuBind : PopupCommentBinding
        lateinit var popupWindow : PopupWindow
        fun bind(data: KomentarItem, context: Context, presenter:KomentarPresenter){
            with(binding) {
                txContent.text = data.komentar
                txUser.text = data.user?.name
                txDate.text= Util.showDate(data.createdAt)
                imUser.bindIcon(context, data.user?.foto)
                val(a,b) = Util.setupPopupView(context,binding.tbMore, R.layout.popup_comment)
                menuBind = PopupCommentBinding.bind(a)
                popupWindow=b

                binding.tbMore.setOnClickListener {
                    popupWindow.showAsDropDown(it)
                }

                menuBind.btDelete.setOnClickListener {
                    data.id?.let { it1 -> presenter.deleteKomentar(it1) }
                    popupWindow.dismiss()
                }

            }
        }

    }
}