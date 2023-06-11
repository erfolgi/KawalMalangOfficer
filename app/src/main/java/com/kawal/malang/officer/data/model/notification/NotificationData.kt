package com.kawal.malang.officer.data.model.notification

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NotificationData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("user_id")
    var userId: Int? = null,
    @SerializedName("relation_id")
    var relationId: Int? = null,
    @SerializedName("kategori")
    var kategori: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("content")
    var content: String? = null,
    @SerializedName("created_at")
    var createdAt: String? = null,
    @SerializedName("updated_at")
    var updatedAt: String? = null
): Parcelable
