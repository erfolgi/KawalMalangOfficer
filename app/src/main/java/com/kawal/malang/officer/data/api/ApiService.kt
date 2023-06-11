package com.kawal.malang.officer.data.api

import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.auth.LoginData
import com.kawal.malang.officer.data.model.auth.MemberData
import com.kawal.malang.officer.data.model.briefing.BriefingData
import com.kawal.malang.officer.data.model.notification.NotificationData
import com.kawal.malang.officer.data.model.panic.report.CategoryData
import com.kawal.malang.officer.data.model.panic.report.PanicCarData
import com.kawal.malang.officer.data.model.panic.report.PanicReportData
import com.kawal.malang.officer.data.model.panic.report.PatrolData
import com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData
import com.kawal.malang.officer.data.model.statistic.StatisticData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    //===============================AUTH==================================//
    @POST("login/officer")
    suspend fun login(
        @Body map: Map<String, String>,
        @Header("FCM") fcmToken: String? = ""
    ): Response<BaseResponse<LoginData>>

    @POST("logout")
    suspend fun logout(@Header("Authorization") token: String): Response<BaseResponse<LoginData>>

    //===============================ACCOUNT================================//
    @GET("user")
    suspend fun getProfile(@Header("Authorization") token: String): Response<LoginData>

    @GET("statistik/mobil")
    suspend fun getStatistic(
        @Header("Authorization") token: String
    ): Response<BaseResponse<StatisticData>>

    @POST("user/mobil")
    suspend fun updateCar(
        @Header("Authorization") token: String,
        @Query("_method") method: String = "PUT",
        @Body body: Map<String, String>
    ): Response<BaseResponse<LoginData>>

    @POST("user/anggota")
    suspend fun updateMember(
        @Header("Authorization") token: String,
        @Query("_method") method: String = "PUT",
        @Body body: Map<String, String>
    ): Response<BaseResponse<LoginData>>

    @POST("user/password")
    suspend fun updatePassword(
        @Header("Authorization") token: String,
        @Query("_method") method: String,
        @Body body: Map<String, String>
    ): Response<BaseResponse<LoginData>>

    @POST("user/foto")
    @Multipart
    suspend fun updatePhoto(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part
    ): Response<BaseResponse<LoginData>>

    //================================PANIC==================================//
    @GET("data/kategori-panic")
    suspend fun getPanicCategory(
        @Header("Authorization") token: String): Response<ArrayList<CategoryData>>

    @GET("panic/mobil")
    suspend fun getPanicReport(
        @Header("Authorization") token: String,
        @Query("kategori_id") categoryId: String?,
        @Query("last_id") lastId: String?,
        @Query("start_date") startDate: String = "",
        @Query("end_date") endDate: String = ""
    ): Response<ArrayList<PanicReportData>>

    @GET("panic/sekitar")
    suspend fun getAroundPanic(
        @Header("Authorization") token: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): Response<ArrayList<PanicReportData>>

    @GET("panic/{id}")
    suspend fun getPanicDetail(
        @Header("Authorization") token: String,
        @Path("id") id: String,
    ): Response<PanicReportData>

    @GET("mobil/tangani")
    suspend fun getActivatedPanic(
        @Header("Authorization") token: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): Response<BaseResponse<PanicReportData>>

    @POST("panic/{id}/tangani")
    suspend fun panicRespond(
        @Header("Authorization") token: String,
        @Path("id") panicId: String,
    ): Response<BaseResponse<PanicCarData>>

    @POST("panic/{id}/selesai")
    suspend fun finishPanic(
        @Header("Authorization") token: String,
        @Path("id") panicId: String,
    ): Response<BaseResponse<PanicReportData>>

    //================================PATROL==================================//
    @GET("data/anggota")
    suspend fun getMembers(
        @Header("Authorization") token: String,
        @Query("search") search: String = ""
    ): Response<ArrayList<MemberData>>

    @GET("patroli")
    suspend fun getPatrolHistory(@Header("Authorization") token: String):
            Response<ArrayList<PatrolData>>

    @POST("patroli/mulai")
    @FormUrlEncoded
    suspend fun doPatrol(
        @Header("Authorization") token: String,
        @Field("anggota_id[]") body: ArrayList<String>
    ): Response<BaseResponse<PatrolData>>

    @POST("patroli/selesai")
    suspend fun finishPatrol(
        @Header("Authorization") token: String,
    ): Response<BaseResponse<PatrolData>>

    @POST("riwayat-lokasi")
    suspend fun recordCarPosition(
        @Header("Authorization") token: String,
        @Body body: Map<String, String>
    ): Response<BaseResponse<LocationHistoryData>>

    //================================BRIEFING==================================//
    @GET("data/kategori-briefing")
    suspend fun getBriefingCategory(
        @Header("Authorization") token: String): Response<ArrayList<CategoryData>>

    @GET("briefing")
    suspend fun getBriefingList(
        @Header("Authorization") token: String,
        @Query("last_id") lastId: String?,
        @Query("kategori_id") categoryId: String?,
        @Query("judul") judul: String = "",
        @Query("tanggal") tanggal: String = ""
    ): Response<ArrayList<BriefingData>>

    @GET("briefing/{id}")
    suspend fun getDetailBriefing(
        @Header("Authorization") token: String,
        @Path("id") id: String,
    ): Response<BriefingData>

    @POST("briefing")
    @Multipart
    suspend fun createBriefing(
        @Header("Authorization") token: String,
        @PartMap body: Map<String, @JvmSuppressWildcards RequestBody>,
        @Part file: MultipartBody.Part
    ): Response<BaseResponse<BriefingData>>

    @POST("briefing/{id}")
    @Multipart
    suspend fun updateBriefing(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @PartMap body: Map<String, @JvmSuppressWildcards RequestBody>,
        @Part file: MultipartBody.Part?,
        @Query("_method") method: String? = "put"
    ): Response<BaseResponse<BriefingData>>

    @POST("briefing/{id}")
    suspend fun deleteBriefing(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Query("_method") method: String = "delete"
    ): Response<BaseResponse<BriefingData>>

    //============================NOTIFICATION==================================//
    @GET("user/notif")
    suspend fun getNotification(
        @Header("Authorization") token: String,
        @Query("last_id") lastId: String
    ): Response<ArrayList<NotificationData>>
}