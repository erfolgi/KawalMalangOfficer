package com.kawal.malang.officer.domain.usecase.auth

import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.auth.LoginData
import com.kawal.malang.officer.domain.repository.AppRepository

class AuthUseCase(private val appRepository: AppRepository) {
    suspend fun execLogin(map: Map<String, String>, fcmToken: String? = ""):
            Resource<BaseResponse<LoginData>> = appRepository.login(map, fcmToken)
    suspend fun execLogout(token: String): Resource<BaseResponse<LoginData>> = appRepository.logout(token)
}