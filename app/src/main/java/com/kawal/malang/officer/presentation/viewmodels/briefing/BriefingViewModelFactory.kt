package com.kawal.malang.officer.presentation.viewmodels.briefing

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kawal.malang.officer.domain.usecase.briefing.BriefingUseCase

class BriefingViewModelFactory (
    private val app: Application,
    private val useCase: BriefingUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = BriefingViewModel(app, useCase) as T
}