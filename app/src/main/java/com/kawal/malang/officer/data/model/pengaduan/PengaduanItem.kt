package com.kawal.malang.officer.data.model.pengaduan

import com.google.gson.annotations.SerializedName
import com.kawal.malang.officer.data.model.briefing.User


data class PengaduanItem(

	@field:SerializedName("keterangan")
	val keterangan: String? = null,

	@field:SerializedName("selesai_bukti")
	val selesaiBukti: String? = null,

	@field:SerializedName("selesai_keterangan")
	val selesaiKeterangan: String? = null,

	@field:SerializedName("distance")
	val distance: Any? = null,

	@field:SerializedName("sub_kategori")
	val subKategori: SubKategori? = null,

	@field:SerializedName("petugas_id")
	val petugasId: Int? = null,

	@field:SerializedName("tempat_kejadian")
	val tempatKejadian: String? = null,

	@field:SerializedName("latitude")
	val latitude: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("kategori")
	val kategori: Kategori? = null,

	@field:SerializedName("selesai_waktu_ditangani")
	val selesaiWaktuDitangani: String? = null,

	@field:SerializedName("petugas")
	val petugas: User? = null,

	@field:SerializedName("kategori_id")
	val kategoriId: Int? = null,

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("sub_kategori_id")
	val subKategoriId: Int? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("longitude")
	val longitude: Any? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Kategori(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("parent_id")
	val parentId: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class SubKategori(

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


