package com.kawal.malang.officer.domain.usecase.panic

import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.panic.report.CategoryData
import com.kawal.malang.officer.data.model.panic.report.PanicCarData
import com.kawal.malang.officer.data.model.panic.report.PanicReportData
import com.kawal.malang.officer.domain.repository.AppRepository

class PanicUseCase(private val repository: AppRepository) {
    suspend fun execGetPanic(
        token: String,
        categoryId: String = "",
        lastId: String = "",
        startDate: String = "",
        endDate: String = ""):
            Resource<ArrayList<PanicReportData>> = repository.getPanicReport(
        token, categoryId, lastId, startDate, endDate)
    suspend fun execGetAroundPanic(token: String, latitude: Double, longitude: Double):
            Resource<ArrayList<PanicReportData>> = repository.getAroundPanic(token, latitude, longitude)
    suspend fun execGetCategory(token: String): Resource<ArrayList<CategoryData>> =
        repository.getPanicCategory(token)
    suspend fun execGetPanicDetail(token: String, id: String): Resource<PanicReportData> =
        repository.getPanicDetail(token, id)
    suspend fun execGetActivatedPanic(token: String, latitude: Double, longitude: Double):
            Resource<BaseResponse<PanicReportData>> = repository.getActivatedPanic(token, latitude, longitude)
    suspend fun execPanicRespond(token: String, panicId: String): Resource<BaseResponse<PanicCarData>> =
        repository.panicRespond(token, panicId)
    suspend fun execFinishPanic(token: String, panicId: String) = repository.finishPanic(token, panicId)
}