package com.kawal.malang.officer.data.repository

import com.kawal.malang.officer.core.util.AppUtil
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
import com.kawal.malang.officer.data.repository.datasource.RemoteDataSource
import com.kawal.malang.officer.domain.repository.AppRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response

class AppRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): AppRepository {
    override suspend fun login(map: Map<String, String>, fcmToken: String?): Resource<BaseResponse<LoginData>> =
        loginToResponse(remoteDataSource.login(map, fcmToken))

    private fun loginToResponse(response: Response<BaseResponse<LoginData>>): Resource<BaseResponse<LoginData>> {
        return try {
            if (response.code() == 200) {
                Resource.Success(response.body())
            } else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    override suspend fun logout(token: String): Resource<BaseResponse<LoginData>> =
        logoutToResponse(remoteDataSource.logout(token))

    private fun logoutToResponse(response: Response<BaseResponse<LoginData>>): Resource<BaseResponse<LoginData>> {
        return try {
            if (response.code() == 200) {
                Resource.Success(response.body())
            } else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    override suspend fun getProfile(token: String): Resource<LoginData> =
        getProfileToResponse(remoteDataSource.getProfile(token))

    private fun getProfileToResponse(response: Response<LoginData>): Resource<LoginData> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }
    private fun statisticToResponse(response: Response<BaseResponse<StatisticData>>): Resource<BaseResponse<StatisticData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    override suspend fun updateCar(
        token: String,
        body: Map<String, String>
    ): Resource<BaseResponse<LoginData>> {
        return updateCarToResponse(remoteDataSource.updateCar(token, body))
    }

    override suspend fun updateMember(
        token: String,
        body: Map<String, String>
    ): Resource<BaseResponse<LoginData>> {
        return updateCarToResponse(remoteDataSource.updateMember(token, body))
    }

    override suspend fun updatePassword(
        token: String,
        body: Map<String, String>
    ): Resource<BaseResponse<LoginData>> {
        return updateCarToResponse(remoteDataSource.updatePassword(token, body))
    }

    override suspend fun updatePhoto(
        token: String,
        file: MultipartBody.Part
    ): Resource<BaseResponse<LoginData>> {
        return updateCarToResponse(remoteDataSource.updatePhoto(token, file))
    }

    private fun updateCarToResponse(response: Response<BaseResponse<LoginData>>): Resource<BaseResponse<LoginData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    override suspend fun getPanicCategory(token: String): Resource<ArrayList<CategoryData>> =
        panicCategoryToResponse(remoteDataSource.getPanicCategory(token))

    private fun panicCategoryToResponse(response: Response<ArrayList<CategoryData>>): Resource<ArrayList<CategoryData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    override suspend fun getPanicReport(
        token: String,
        categoryId: String,
        lastId: String,
        startDate: String,
        endDate: String): Resource<ArrayList<PanicReportData>> {
        return getPanicToResponse(remoteDataSource.getPanicReport(token, categoryId, lastId,
            startDate, endDate))
    }

    override suspend fun getAroundPanic(
        token: String,
        latitude: Double,
        longitude: Double
    ): Resource<ArrayList<PanicReportData>> {
        return getPanicToResponse(remoteDataSource.getAroundPanic(token, latitude, longitude))
    }

    private fun getPanicToResponse(response: Response<ArrayList<PanicReportData>>): Resource<ArrayList<PanicReportData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    override suspend fun getPanicDetail(token: String, id: String): Resource<PanicReportData> =
        getPanicDetailToResponse(remoteDataSource.getPanicDetail(token, id))

    private fun getPanicDetailToResponse(response: Response<PanicReportData>): Resource<PanicReportData> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    override suspend fun getActivatedPanic(
        token: String,
        latitude: Double,
        longitude: Double
    ): Resource<BaseResponse<PanicReportData>> = getActivatedToResponse(remoteDataSource
        .getActivatedPanic(token, latitude, longitude))

    private fun getActivatedToResponse(response: Response<BaseResponse<PanicReportData>>): Resource<BaseResponse<PanicReportData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occured")
        }
    }

    override suspend fun panicRespond(
        token: String,
        panicId: String
    ): Resource<BaseResponse<PanicCarData>> = panicRespondToResponse(remoteDataSource.panicRespond(
        token, panicId))

    private fun panicRespondToResponse(response: Response<BaseResponse<PanicCarData>>): Resource<BaseResponse<PanicCarData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    override suspend fun finishPanic(token: String, panicId: String): Resource<BaseResponse<PanicReportData>> =
        finishPanicToResponse(remoteDataSource.finishPanic(token, panicId))

    private fun finishPanicToResponse(response: Response<BaseResponse<PanicReportData>>): Resource<BaseResponse<PanicReportData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    override suspend fun getMembers(token: String, search: String): Resource<ArrayList<MemberData>> =
        getMembersToResponse(remoteDataSource.getMembers(token, search))

    private fun getMembersToResponse(response: Response<ArrayList<MemberData>>): Resource<ArrayList<MemberData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    private fun patrolHistoryToResponse(response: Response<ArrayList<PatrolData>>): Resource<ArrayList<PatrolData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    private fun doPatrolToResponse(response: Response<BaseResponse<PatrolData>>): Resource<BaseResponse<PatrolData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }


    private fun finishPatrolToResponse(response: Response<BaseResponse<PatrolData>>): Resource<BaseResponse<PatrolData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    override suspend fun recordCarLocation(
        token: String,
        body: Map<String, String>
    ): Resource<BaseResponse<LocationHistoryData>> = recordCarToResponse(
        remoteDataSource.recordCarPosition(token, body))

    private fun recordCarToResponse(response: Response<BaseResponse<LocationHistoryData>>): Resource<BaseResponse<LocationHistoryData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }



    private fun briefingCategoryToResponse(response: Response<ArrayList<CategoryData>>): Resource<ArrayList<CategoryData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }


    private fun getBriefingToResponse(response: Response<ArrayList<BriefingData>>): Resource<ArrayList<BriefingData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }



    private fun detailBriefingToResponse(response: Response<BriefingData>): Resource<BriefingData> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }






    private fun postBriefingToResponse(response: Response<BaseResponse<BriefingData>>): Resource<BaseResponse<BriefingData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }

    override suspend fun getNotification(
        token: String,
        lastId: String
    ): Resource<ArrayList<NotificationData>> {
        return notificationToResponse(remoteDataSource.getNotification(token, lastId))
    }

    private fun notificationToResponse(response: Response<ArrayList<NotificationData>>): Resource<ArrayList<NotificationData>> {
        return try {
            if (response.code() == 200) Resource.Success(response.body())
            else Resource.Error(AppUtil.errorMessage(response.errorBody()?.string()) ?: "Error")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("An error occurred")
        }
    }
}