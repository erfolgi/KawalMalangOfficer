package com.kawal.malang.officer.data.repository.datasource

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

interface RemoteDataSource {
    //=========================AUTH=============================//
    suspend fun login(map: Map<String, String>, fcmToken: String? = ""):
            Response<BaseResponse<LoginData>>
    suspend fun logout(token: String): Response<BaseResponse<LoginData>>

    //=========================ACCOUNT==========================//
    suspend fun getProfile(token: String): Response<LoginData>
    suspend fun getStatistic(token: String): Response<BaseResponse<StatisticData>>
    suspend fun updateCar(token: String, body: Map<String, String>): Response<BaseResponse<LoginData>>
    suspend fun updatePassword(token: String, body: Map<String, String>): Response<BaseResponse<LoginData>>
    suspend fun updateMember(token: String, body: Map<String, String>): Response<BaseResponse<LoginData>>
    suspend fun updatePhoto(token: String, file: MultipartBody.Part): Response<BaseResponse<LoginData>>
    //==========================PANIC===========================//
    suspend fun getPanicCategory(token: String): Response<ArrayList<CategoryData>>
    suspend fun getPanicReport(
        token: String,
        categoryId: String,
        lastId: String,
        startDate: String = "",
        endDate: String = ""
    ): Response<ArrayList<PanicReportData>>
    suspend fun getAroundPanic(token: String, latitude: Double, longitude: Double):
            Response<ArrayList<PanicReportData>>
    suspend fun getActivatedPanic(token: String, latitude: Double, longitude: Double):
            Response<BaseResponse<PanicReportData>>
    suspend fun getPanicDetail(token: String, id: String): Response<PanicReportData>
    suspend fun panicRespond(token: String, panicId: String): Response<BaseResponse<PanicCarData>>
    suspend fun finishPanic(token: String, panicId: String): Response<BaseResponse<PanicReportData>>

    //===========================PATROL==========================//
    suspend fun getMembers(token: String, search: String = ""): Response<ArrayList<MemberData>>
    suspend fun getPatrolHistory(token: String): Response<ArrayList<PatrolData>>
    suspend fun doPatrol(token: String, body: ArrayList<String>): Response<BaseResponse<PatrolData>>
    suspend fun finishPatrol(token: String): Response<BaseResponse<PatrolData>>
    suspend fun recordCarPosition(token: String, body: Map<String, String>):
            Response<BaseResponse<LocationHistoryData>>

    //==============================BRIEFING================================//
    suspend fun getBriefingCategory(token: String): Response<ArrayList<CategoryData>>
    suspend fun getBriefingList(token: String,lastId:String,categoryId:String,judul:String,tanggal:String): Response<ArrayList<BriefingData>>
    suspend fun getDetailBriefing(token: String, id: String): Response<BriefingData>
    suspend fun createBriefing(token: String, body: Map<String, RequestBody>, file: MultipartBody.Part):
            Response<BaseResponse<BriefingData>>
    suspend fun updateBriefing(token: String, id: String, body: Map<String, RequestBody>, file: MultipartBody.Part?):
            Response<BaseResponse<BriefingData>>
    suspend fun deleteBriefing(token: String, id: String): Response<BaseResponse<BriefingData>>

    //===============================NOTIFICATION============================//
    suspend fun getNotification(token: String, lastId: String): Response<ArrayList<NotificationData>>
}