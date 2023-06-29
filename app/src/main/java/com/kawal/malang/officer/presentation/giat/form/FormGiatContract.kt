package com.kawal.malang.officer.presentation.giat.form

import com.kawal.malang.officer.core.util.BaseContract
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem

interface FormGiatContract:BaseContract {
    fun onSubmit(message:String, data: GiatItem)
}