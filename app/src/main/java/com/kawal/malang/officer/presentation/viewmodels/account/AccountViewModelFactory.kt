package com.kawal.malang.officer.presentation.viewmodels.account

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kawal.malang.officer.domain.usecase.account.AccountUseCase

class AccountViewModelFactory(
    private val app: Application,
    private val useCase: AccountUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        AccountViewModel(app, useCase) as T
}