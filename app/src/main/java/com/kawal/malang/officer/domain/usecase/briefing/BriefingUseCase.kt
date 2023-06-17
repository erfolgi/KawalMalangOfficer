package com.kawal.malang.officer.domain.usecase.briefing

import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.briefing.BriefingData
import com.kawal.malang.officer.data.model.panic.report.CategoryData
import com.kawal.malang.officer.domain.repository.AppRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody

class BriefingUseCase(private val repository: AppRepository) {
}