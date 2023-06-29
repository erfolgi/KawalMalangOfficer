package com.kawal.malang.citizen.ui.bantuan

import android.app.Activity
import com.kawal.malang.officer.R

object BantuanConst {
    var presisiList : ArrayList<MenuModel> = arrayListOf(
        MenuModel("Intelkam", R.drawable.ic_intelkam),
        MenuModel("Reserse", R.drawable.ic_reserse),
        MenuModel("Lalu Lintas", R.drawable.ic_lalu_lintas),
        MenuModel("Unggulan", R.drawable.ic_logo_new),
        MenuModel("Simatahati", R.drawable.ic_simatahati),
        MenuModel("Saber Pungli", R.drawable.ic_pungli),
        MenuModel("Info Layanan", R.drawable.ic_info_layanan),
    )
}

class MenuModel(
    var title:String,
    var icon:Int,
    var activity:Activity?=null
    )