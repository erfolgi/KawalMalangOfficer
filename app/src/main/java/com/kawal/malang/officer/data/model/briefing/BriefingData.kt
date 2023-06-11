package com.kawal.malang.officer.data.model.briefing

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BriefingData(

	@field:SerializedName("anggota")
	val anggota: Anggota? = null,

	@field:SerializedName("kategori_id")
	val kategoriId: Int? = null,

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("lokasi")
	val lokasi: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("kategori")
	val kategori: Kategori? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("anggota_id")
	val anggotaId: Int? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null
):Parcelable

@Parcelize
data class Anggota(

	@field:SerializedName("nip")
	val nip: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("pangkat")
	val pangkat: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("user")
	val user: User? = null
):Parcelable

@Parcelize
data class User(

	@field:SerializedName("is_active")
	val isActive: Int? = null,

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("telepon")
	val telepon: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null
):Parcelable

@Parcelize
data class Kategori(

	@field:SerializedName("keterangan")
	val keterangan: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
):Parcelable
