package com.kawal.malang.citizen.model.response.pengaduan

import com.google.gson.annotations.SerializedName

data class KategoriPengaduanItem(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("parent_id")
	val parentId: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
