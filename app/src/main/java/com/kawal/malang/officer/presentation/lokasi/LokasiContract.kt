package com.kawal.malang.officer.presentation.lokasi

import com.kawal.malang.citizen.model.response.pengaduan.KategoriPengaduanItem
import com.kawal.malang.citizen.model.response.pengaduan.lokasi.LokasiItem
import com.kawal.malang.officer.core.util.BaseContract

interface LokasiContract : BaseContract {
    fun onLoad(data : ArrayList<LokasiItem>)
    fun onLoadKategori(data : ArrayList<KategoriPengaduanItem>)
}