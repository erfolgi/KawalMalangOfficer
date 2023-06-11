package com.kawal.malang.officer.presentation.viewmodels.patrol

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kawal.malang.officer.domain.usecase.patrol.PatrolUseCase

class PatrolViewModelFactory(
    private val app: Application,
    private val useCase: PatrolUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = PatrolViewModel(app, useCase) as T
}