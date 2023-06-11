package com.kawal.malang.officer.presentation.viewmodels.notification

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.notification.NotificationData
import com.kawal.malang.officer.domain.usecase.notification.NotificationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotificationViewModel(
    private val app: Application,
    private val useCase: NotificationUseCase
): AndroidViewModel(app) {
    private val pref = AppPreference(app.applicationContext)
    val notifications: MutableLiveData<Resource<ArrayList<NotificationData>>> = MutableLiveData()
    val paginate: MutableLiveData<Resource<ArrayList<NotificationData>>> = MutableLiveData()

    fun getNotifications(lastId: String = "") = viewModelScope.launch(Dispatchers.IO) {
        notifications.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetNotification(pref.getAuth(), lastId)
                notifications.postValue(result)
            } else notifications.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            notifications.postValue(Resource.Error("An error occurred"))
        }
    }

    fun refreshNotifications() = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetNotification(pref.getAuth(), "")
                notifications.postValue(result)
            } else notifications.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            notifications.postValue(Resource.Error("An error occurred"))
        }
    }

    fun paginateNotification(lastId: String = "") = viewModelScope.launch(Dispatchers.IO) {
        paginate.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetNotification(pref.getAuth(), lastId)
                paginate.postValue(result)
            } else paginate.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            paginate.postValue(Resource.Error("An error occurred"))
        }
    }
}