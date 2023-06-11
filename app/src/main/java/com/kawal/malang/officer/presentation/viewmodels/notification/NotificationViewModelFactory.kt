package com.kawal.malang.officer.presentation.viewmodels.notification

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kawal.malang.officer.domain.usecase.notification.NotificationUseCase

class NotificationViewModelFactory(
    private val app: Application,
    private val useCase: NotificationUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotificationViewModel(app, useCase) as T
    }
}