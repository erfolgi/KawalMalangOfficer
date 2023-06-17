package com.kawal.malang.officer.domain.usecase.patrol

import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.auth.MemberData
import com.kawal.malang.officer.data.model.panic.report.PatrolData
import com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData
import com.kawal.malang.officer.domain.repository.AppRepository

class PatrolUseCase(private val repository: AppRepository) {
    suspend fun execGetMembers(token: String, search: String = ""): Resource<ArrayList<MemberData>> =
        repository.getMembers(token, search)

    suspend fun execRecordPosition(token: String, body: Map<String, String>): Resource<BaseResponse<LocationHistoryData>> =
        repository.recordCarLocation(token, body)
}