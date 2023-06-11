package com.kawal.malang.officer.data.api

import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiCall {
    @POST("riwayat-lokasi")
    fun recordCarPositionCall(
        @Header("Authorization") token: String,
        @Body body: Map<String, String>
    ): Call<BaseResponse<LocationHistoryData>>
}