package com.kawal.malang.citizen.model.response.pengaduan.agenda

import com.google.gson.annotations.SerializedName

data class AgendaItem(

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null
)
