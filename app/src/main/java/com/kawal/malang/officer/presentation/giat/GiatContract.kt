package com.kawal.malang.officer.presentation.giat

import com.kawal.malang.officer.core.util.BaseContract
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem

interface GiatContract: BaseContract {
    fun onLoad(data:ArrayList<GiatItem>)
}