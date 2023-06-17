package com.kawal.malang.officer.domain.repository

import com.kawal.malang.officer.core.util.Resource
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

interface AppRepository {
    //================================AUTH===============================//
    suspend fun login(map: Map<String, String>, fcmToken: String? = ""): Resource<BaseResponse<LoginData>>
    suspend fun logout(token: String): Resource<BaseResponse<LoginData>>
    //============================ACCOUNT================================//
    suspend fun getProfile(token: String): Resource<LoginData>
    suspend fun updateCar(token: String, body: Map<String, String>): Resource<BaseResponse<LoginData>>
    suspend fun updateMember(token: String, body: Map<String, String>): Resource<BaseResponse<LoginData>>
    suspend fun updatePassword(token: String, body: Map<String, String>): Resource<BaseResponse<LoginData>>
    suspend fun updatePhoto(token: String, file: MultipartBody.Part): Resource<BaseResponse<LoginData>>
    //==============================PANIC================================//
    suspend fun getPanicCategory(token: String): Resource<ArrayList<CategoryData>>
    suspend fun getPanicReport(
        token: String,
        categoryId: String,
        lastId: String,
        startDate: String = "",
        endDate: String = ""
    ): Resource<ArrayList<PanicReportData>>
    suspend fun getAroundPanic(token: String, latitude: Double, longitude: Double):
            Resource<ArrayList<PanicReportData>>
    suspend fun getPanicDetail(token: String, id: String): Resource<PanicReportData>
    suspend fun getActivatedPanic(token: String, latitude: Double, longitude: Double): Resource<BaseResponse<PanicReportData>>
    suspend fun panicRespond(token: String, panicId: String): Resource<BaseResponse<PanicCarData>>
    suspend fun finishPanic(token: String, panicId: String):
            Resource<BaseResponse<PanicReportData>>
    //==============================PATROL================================//
    suspend fun getMembers(token: String, search: String = ""): Resource<ArrayList<MemberData>>


    suspend fun recordCarLocation(token: String, body: Map<String, String>): Resource<BaseResponse<LocationHistoryData>>

    //===========================NOTIFICATION===============================//
    suspend fun getNotification(token: String, lastId: String): Resource<ArrayList<NotificationData>>
}