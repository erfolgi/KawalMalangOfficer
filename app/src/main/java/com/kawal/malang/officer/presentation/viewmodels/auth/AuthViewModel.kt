package com.kawal.malang.officer.presentation.viewmodels.auth

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.auth.LoginData
import com.kawal.malang.officer.domain.usecase.auth.AuthUseCase
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel(
    private val app: Application,
    private val authUseCase: AuthUseCase
): AndroidViewModel(app) {
    private val pref = AppPreference(app.applicationContext)
    val loginData: MutableLiveData<Resource<BaseResponse<LoginData>>> = MutableLiveData()
    val logoutData: MutableLiveData<Resource<BaseResponse<LoginData>>> = MutableLiveData()

    fun doLogin(map: Map<String, String>) = viewModelScope.launch(Dispatchers.IO) {
        loginData.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                getFcmToken()
                val result = authUseCase.execLogin(map, pref.getFcmToken())
                loginData.postValue(result)
            } else loginData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            loginData.postValue(Resource.Error("An error occured"))
        }
    }

    fun doLogout() = viewModelScope.launch(Dispatchers.IO) {
        logoutData.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val pref = AppPreference(app.applicationContext)
                val result = authUseCase.execLogout(pref.getAuth())
                logoutData.postValue(result)
            } else logoutData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            logoutData.postValue(Resource.Error("An error occurred"))
        }
    }

    private fun getFcmToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            try {
                val token = task.result
                pref.setFcmToken(token)
            } catch (e: Exception) {
                Log.d("FcmException", "$e")
            }
        }
    }

}