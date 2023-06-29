package com.kawal.malang.citizen.model.response.pengaduan.lokasi

import com.google.gson.annotations.SerializedName

data class LokasiItem(

	@field:SerializedName("kategori_id")
	val kategoriId: Int? = null,

	@field:SerializedName("keterangan")
	val keterangan: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("distance")
	val distance: Any? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("latitude")
	val latitude: Double? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("kategori")
	val kategori: Kategori? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("longitude")
	val longitude: Double? = null
)

data class Kategori(

	@field:SerializedName("keterangan")
	val keterangan: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
