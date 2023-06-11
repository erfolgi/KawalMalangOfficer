package com.kawal.malang.officer.domain.usecase.account

import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.auth.LoginData
import com.kawal.malang.officer.data.model.statistic.StatisticData
import com.kawal.malang.officer.domain.repository.AppRepository
import okhttp3.MultipartBody

class AccountUseCase(private val repository: AppRepository) {
    suspend fun execGetProfile(token: String): Resource<LoginData> = repository.getProfile(token)
    suspend fun execGetStatistic(token: String): Resource<BaseResponse<StatisticData>> =
        repository.getStatistic(token)
    suspend fun execUpdateCar(token: String, body: Map<String, String>): Resource<BaseResponse<LoginData>> =
        repository.updateCar(token, body)
    suspend fun execUpdateMember(token: String, body: Map<String, String>): Resource<BaseResponse<LoginData>> =
        repository.updateMember(token, body)
    suspend fun execUpdatePassword(token: String, body: Map<String, String>): Resource<BaseResponse<LoginData>> =
        repository.updatePassword(token, body)
    suspend fun execUpdatePhoto(token: String, file: MultipartBody.Part): Resource<BaseResponse<LoginData>> =
        repository.updatePhoto(token, file)
}