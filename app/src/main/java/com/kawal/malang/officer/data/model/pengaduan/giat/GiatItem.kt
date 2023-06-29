package com.kawal.malang.officer.data.model.pengaduan.giat

import com.google.gson.annotations.SerializedName
import com.kawal.malang.officer.data.model.briefing.User

data class GiatItem(

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("komentar")
	val komentar: ArrayList<KomentarItem?> = ArrayList(),

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("komentar_count")
	val komentarCount: Int? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class KomentarItem(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("komentar")
	val komentar: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("giat_id")
	val giatId: Int? = null
)

