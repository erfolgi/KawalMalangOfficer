package com.kawal.malang.officer.data.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<Data>(
    @field:SerializedName("status")
    val status: Boolean? = null,
    @field:SerializedName("message")
    val message: String? = null,
    @field:SerializedName("data")
    val data: Data? = null,
)
