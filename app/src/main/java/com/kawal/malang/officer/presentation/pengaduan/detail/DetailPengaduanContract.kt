package com.kawal.malang.officer.presentation.pengaduan.detail

import com.kawal.malang.officer.core.util.BaseContract
import com.kawal.malang.officer.data.model.pengaduan.PengaduanItem

interface DetailPengaduanContract: BaseContract {
    fun onLoad(data: PengaduanItem)
    fun onDelete(message:String)
}