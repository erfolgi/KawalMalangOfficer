package com.kawal.malang.officer.presentation.viewmodels.panic

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kawal.malang.officer.domain.usecase.panic.PanicUseCase

class PanicViewModelFactory(
    private val app: Application,
    private val useCase: PanicUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = PanicViewModel(app, useCase) as T
}