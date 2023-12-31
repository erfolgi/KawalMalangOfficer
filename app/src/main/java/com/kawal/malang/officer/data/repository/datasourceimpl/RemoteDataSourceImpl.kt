package com.kawal.malang.officer.data.repository.datasourceimpl

import com.kawal.malang.officer.data.api.ApiService
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
import com.kawal.malang.officer.data.repository.datasource.RemoteDataSource
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response

class RemoteDataSourceImpl(
    private val service: ApiService
): RemoteDataSource {
    override suspend fun login(map: Map<String, String>, fcmToken: String?)
    : Response<BaseResponse<LoginData>> = service.login(map, fcmToken)

    override suspend fun logout(token: String): Response<BaseResponse<LoginData>> = service.logout(token)

    override suspend fun getProfile(token: String): Response<LoginData> = service.getProfile(token)



    override suspend fun updateCar(
        token: String,
        body: Map<String, String>
    ): Response<BaseResponse<LoginData>> = service.updateCar(token, "PUT", body)

    override suspend fun updatePassword(
        token: String,
        body: Map<String, String>
    ): Response<BaseResponse<LoginData>> = service.updatePassword(token, "PUT", body)

    override suspend fun updateMember(
        token: String,
        body: Map<String, String>
    ): Response<BaseResponse<LoginData>> {
        return service.updateMember(token, "PUT", body)
    }

    override suspend fun updatePhoto(
        token: String,
        file: MultipartBody.Part
    ): Response<BaseResponse<LoginData>> = service.updatePhoto(token, file)

    override suspend fun getPanicCategory(token: String): Response<ArrayList<CategoryData>> =
        service.getPanicCategory(token)

    override suspend fun getPanicReport(
        token: String,
        categoryId: String,
        lastId: String,
        startDate: String,
        endDate: String
    ): Response<ArrayList<PanicReportData>> = service.getPanicReport(token, categoryId, lastId,
        startDate, endDate)

    override suspend fun getAroundPanic(
        token: String,
        latitude: Double,
        longitude: Double
    ): Response<ArrayList<PanicReportData>> = service.getAroundPanic(token, latitude, longitude)

    override suspend fun getActivatedPanic(
        token: String,
        latitude: Double,
        longitude: Double
    ): Response<BaseResponse<PanicReportData>> = service.getActivatedPanic(token, latitude, longitude)

    override suspend fun getPanicDetail(token: String, id: String): Response<PanicReportData> =
        service.getPanicDetail(token, id)

    override suspend fun panicRespond(
        token: String,
        panicId: String
    ): Response<BaseResponse<PanicCarData>> = service.panicRespond(token, panicId)

    override suspend fun finishPanic(
        token: String,
        panicId: String,
    ): Response<BaseResponse<PanicReportData>> = service.finishPanic(token, panicId)

    override suspend fun getMembers(token: String, search: String): Response<ArrayList<MemberData>> =
        service.getMembers(token, search)


    override suspend fun recordCarPosition(
        token: String,
        body: Map<String, String>
    ): Response<BaseResponse<LocationHistoryData>> = service.recordCarPosition(token, body)


    override suspend fun getNotification(
        token: String,
        lastId: String
    ): Response<ArrayList<NotificationData>> = service.getNotification(token, lastId)
}