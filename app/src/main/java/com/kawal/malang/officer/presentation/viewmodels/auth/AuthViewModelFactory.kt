package com.kawal.malang.officer.presentation.viewmodels.auth

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kawal.malang.officer.domain.usecase.auth.AuthUseCase

class AuthViewModelFactory(
    private val app: Application,
    private val authUseCase: AuthUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        AuthViewModel(app, authUseCase) as T
}