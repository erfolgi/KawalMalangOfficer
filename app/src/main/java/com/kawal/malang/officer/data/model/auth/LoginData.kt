package com.kawal.malang.officer.data.model.auth

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginData(
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
    @SerializedName("fcm")
    var fcm: String? = null,
    @SerializedName("is_active")
    var isActive: Int? = null,
    @SerializedName("created_at")
    var createdAt: String? = null,
    @SerializedName("roles")
    var roles: ArrayList<RoleData>? = null,
    @SerializedName("mobil")
    var car: CarData? = null,
    @SerializedName("anggota")
    var member: MemberData? = null,
    @SerializedName("jwt")
    var jwt: String? = null
): Parcelable

@Parcelize
data class RoleData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String? = null
): Parcelable

@Parcelize
data class CarData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("user_id")
    var userId: Int? = null,
    @SerializedName("user")
    var user: UserData? = null,
    @SerializedName("nopol")
    var carNumber: String? = null,
    @SerializedName("status_patroli")
    var patrolStatus: Int,
    @SerializedName("merk")
    var brand: String? = null,
    @SerializedName("deskripsi")
    var desc: String? = null,
    @SerializedName("latitude")
    var latitude: Double? = null,
    @SerializedName("longitude")
    var longitude: Double? = null,
    @SerializedName("created_at")
    var createdAt: String? = null,
    @SerializedName("updated_at")
    var updatedAt: String? = null
): Parcelable

@Parcelize
data class MemberData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("user_id")
    var userId: Int? = null,
    @SerializedName("user")
    var user: UserData? = null,
    @SerializedName("nip")
    var nip: String? = null,
    @SerializedName("pangkat")
    var rank: String? = null
): Parcelable

@Parcelize
data class UserData(
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