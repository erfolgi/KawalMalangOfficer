package com.kawal.malang.officer.presentation.pengaduan

import com.kawal.malang.citizen.model.response.pengaduan.KategoriPengaduanItem
import com.kawal.malang.officer.core.util.BaseContract
import com.kawal.malang.officer.data.model.pengaduan.PengaduanItem

interface PengaduanContract: BaseContract {
    fun onLoad(data:ArrayList<PengaduanItem>)
    fun onLoadKategori(data : ArrayList<KategoriPengaduanItem>, isParent:Boolean)
}