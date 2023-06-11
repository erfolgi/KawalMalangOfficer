package com.kawal.malang.officer.data.model.patrol.history

import android.os.Parcelable
import com.kawal.malang.officer.data.model.auth.CarData
import com.kawal.malang.officer.data.model.panic.report.PatrolData
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationHistoryData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("mobil_id")
    var carId: Int? = null,
    @SerializedName("mobil")
    var car: CarData? = null,
    @SerializedName("patroli_id")
    var patrolId: Int? = null,
    @SerializedName("patroli")
    var patrol: PatrolData? = null,
    @SerializedName("latitude")
    var latitude: Double? = null,
    @SerializedName("longitude")
    var longitude: Double? = null,
    @SerializedName("created_at")
    var createdAt: String? = null,
    @SerializedName("updated_at")
    var updatedAt: String? = null

): Parcelable
