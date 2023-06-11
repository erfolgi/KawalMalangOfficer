package com.kawal.malang.officer.domain.usecase.notification

import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.notification.NotificationData
import com.kawal.malang.officer.domain.repository.AppRepository

class NotificationUseCase(private val repository: AppRepository) {
    suspend fun execGetNotification(token: String, lastId: String): Resource<ArrayList<NotificationData>> =
        repository.getNotification(token, lastId)
}