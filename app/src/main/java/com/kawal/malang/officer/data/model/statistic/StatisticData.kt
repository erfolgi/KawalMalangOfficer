package com.kawal.malang.officer.data.model.statistic

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatisticData(
    @SerializedName("totalPanic")
    var totalPanic: Int? = null,
    @SerializedName("jarakTotal")
    var totalDistance: Double? = null,
    @SerializedName("jarakToday")
    var todayDistance: Double? = null
): Parcelable
