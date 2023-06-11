package com.kawal.malang.officer.data.model.panic.report

import android.os.Parcelable
import com.kawal.malang.officer.data.model.auth.CarData
import com.kawal.malang.officer.data.model.auth.MemberData
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PanicReportData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("pelapor_id")
    var reporterId: Int? = null,
    @SerializedName("pelapor")
    var reporter: ReporterData? = null,
    @SerializedName("kategori_id")
    var categoryId: Int? = null,
    @SerializedName("kategori")
    var category: CategoryData? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("latitude")
    var latitude: Double? = null,
    @SerializedName("longitude")
    var longitude: Double? = null,
    @SerializedName("foto")
    var photo: String? = null,
    @SerializedName("keterangan")
    var information: String? = null,
    @SerializedName("catatan")
    var note: String? = null,
    @SerializedName("deskripsi_kejadian")
    var eventDescription: String? = null,
    @SerializedName("laporan_petugas")
    var officerReport: String? = null,
    @SerializedName("foto_petugas")
    var officerPhoto: String? = null,
    @SerializedName("mobil_penyelesai_id")
    var carFinisherId: Int? = null,
    @SerializedName("mobil_penyelesai")
    var carFinisher: CarData? = null,
    @SerializedName("created_at")
    var createdAt: String? = null,
    @SerializedName("updated_at")
    var updatedAt: String? = null,
    @SerializedName("mobil_panic")
    var panicCar: ArrayList<PanicCarData>? = null,
    @SerializedName("distance")
    var distance: Double? = null,
    @SerializedName("waktu")
    var time: Double? = null,
    @SerializedName("timeline")
    var timeline: ArrayList<TimelineData>? = arrayListOf(),
    @SerializedName("rating")
    var rating: Int? = null,
    @SerializedName("keterangan_rating")
    var ratingDesc: String? = null
): Parcelable

@Parcelize
data class ReporterData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("username")
    var username: String? = null,
    @SerializedName("telepon")
    var phone: String? = null,
    @SerializedName("foto")
    var photo: String? = null,
    @SerializedName("is_active")
    var isActive: Int? = null
): Parcelable

@Parcelize
data class CategoryData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("nama")
    var name: String? = null,
    @SerializedName("icon")
    var icon: String? = null,
    @SerializedName("marker_icon")
    var markerIcon: String? = null
): Parcelable

@Parcelize
data class PanicCarData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("panic_id")
    var panicId: Int? = null,
    @SerializedName("panic")
    var panic: PanicReportData? = null,
    @SerializedName("mobil_id")
    var carId: Int? = null,
    @SerializedName("mobil")
    var car: CarData? = null,
    @SerializedName("patroli_id")
    var patrolId: Int? = null,
    @SerializedName("patroli")
    var patrol: PatrolData? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("created_at")
    var createdAt: String? = null,
    @SerializedName("updated_at")
    var updatedAt: String? = null
): Parcelable

@Parcelize
data class PatrolData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("mobil")
    var car: CarData? = null,
    @SerializedName("waktu_mulai")
    var startTime: String? = null,
    @SerializedName("waktu_selesai")
    var endTime: String? = null,
    @SerializedName("jarak")
    var distance: Double? = null,
    @SerializedName("keterangan")
    var desc: String? = null,
    @SerializedName("created_at")
    var createdAt: String? = null,
    @SerializedName("updated_at")
    var updatedAt: String? = null,
    @SerializedName("anggota")
    var member: ArrayList<MemberData>? = null,
): Parcelable

@Parcelize
data class TimelineData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("panic_id")
    var panicId: Int? = null,
    @SerializedName("user_id")
    var userId: Int? = null,
    @SerializedName("judul")
    var title: String? = null,
    @SerializedName("keterangan")
    var desc: String? = null,
    @SerializedName("created_at")
    var createdAt: String? = null,
    @SerializedName("updated_at")
    var updatedAt: String? = null
): Parcelable