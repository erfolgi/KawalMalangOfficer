package com.kawal.malang.officer.presentation.giat.detail

import com.kawal.malang.officer.core.util.BaseContract
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem

interface DetailGiatContract: BaseContract {
    fun onLoad(data: GiatItem)
    fun onDelete(message:String)
}