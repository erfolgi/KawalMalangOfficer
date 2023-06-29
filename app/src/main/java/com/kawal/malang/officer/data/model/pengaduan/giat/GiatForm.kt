package com.kawal.malang.officer.data.model.pengaduan.giat

import com.google.gson.annotations.SerializedName
import com.kawal.malang.officer.data.model.briefing.User

data class GiatForm(
    @field:SerializedName("judul")
    var judul: String? = null,

    @field:SerializedName("deskripsi")
    var deskripsi: String? = null,

    @field:SerializedName("url")
    var url: String? = null
)
