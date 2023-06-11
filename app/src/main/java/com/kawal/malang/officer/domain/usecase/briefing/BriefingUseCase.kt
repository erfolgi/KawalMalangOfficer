package com.kawal.malang.officer.domain.usecase.briefing

import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.briefing.BriefingData
import com.kawal.malang.officer.data.model.panic.report.CategoryData
import com.kawal.malang.officer.domain.repository.AppRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody

class BriefingUseCase(private val repository: AppRepository) {
    suspend fun execGetBriefing(
        token: String,
        lastId: String = "",
        categoryId: String = "",
        judul: String = "",
        tanggal: String = ""):
            Resource<ArrayList<BriefingData>> = repository.getBriefingList(
        token, lastId,categoryId,judul,tanggal)
    suspend fun execGetDetail(token: String, id: String): Resource<BriefingData> =
        repository.getDetailBriefing(token, id)
    suspend fun execGetCategory(token: String): Resource<ArrayList<CategoryData>> =
        repository.getBriefingCategory(token)
    suspend fun execCreate(token: String, body: Map<String, RequestBody>, file: MultipartBody.Part):
            Resource<BaseResponse<BriefingData>> = repository.createBriefing(token, body, file)
    suspend fun execUpdate(token: String, id: String, body: Map<String, RequestBody>, file: MultipartBody.Part?):
            Resource<BaseResponse<BriefingData>> = repository.updateBriefing(token, id, body, file)
    suspend fun execDelete(token: String, id: String): Resource<BaseResponse<BriefingData>> =
        repository.deleteBriefing(token, id)
}