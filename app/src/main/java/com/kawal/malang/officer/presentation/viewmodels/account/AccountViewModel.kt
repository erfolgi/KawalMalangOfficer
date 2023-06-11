package com.kawal.malang.officer.presentation.viewmodels.account

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.auth.LoginData
import com.kawal.malang.officer.data.model.statistic.StatisticData
import com.kawal.malang.officer.domain.usecase.account.AccountUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class AccountViewModel(
    private val app: Application,
    private val useCase: AccountUseCase
): AndroidViewModel(app) {
    private val pref = AppPreference(app.applicationContext)
    val profile: MutableLiveData<Resource<LoginData>> = MutableLiveData()
    val update: MutableLiveData<Resource<BaseResponse<LoginData>>> = MutableLiveData()
    val statistic: MutableLiveData<Resource<BaseResponse<StatisticData>>> = MutableLiveData()
    fun getProfile() = viewModelScope.launch(Dispatchers.IO) {
        profile.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val token = pref.getAuth()
                val result = useCase.execGetProfile(token)
                profile.postValue(result)
            } else profile.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            profile.postValue(Resource.Error("An error occurred"))
        }
    }

    fun getStatistic() = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetStatistic(pref.getAuth())
                statistic.postValue(result)
            } else statistic.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            statistic.postValue(Resource.Error("An error occurred"))
        }
    }

    fun updateCar(body: Map<String, String>) = viewModelScope.launch(Dispatchers.IO) {
        update.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execUpdateCar(pref.getAuth(), body)
                update.postValue(result)
            } else update.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            update.postValue(Resource.Error("An error occurred"))
        }
    }

    fun updateMember(body: Map<String, String>) = viewModelScope.launch(Dispatchers.IO) {
        update.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execUpdateMember(pref.getAuth(), body)
                update.postValue(result)
            } else update.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            update.postValue(Resource.Error("An error occurred"))
        }
    }

    fun updatePassword(body: Map<String, String>) = viewModelScope.launch(Dispatchers.IO) {
        update.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execUpdatePassword(pref.getAuth(), body)
                update.postValue(result)
            } else update.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            update.postValue(Resource.Error("An error occurred"))
        }
    }

    fun updatePhoto(file: File) = viewModelScope.launch(Dispatchers.IO) {
        update.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val reqFile = RequestBody.create(MediaType.parse("image/*"), file)
                val part = MultipartBody.Part.createFormData("foto", file.name, reqFile)
                val result = useCase.execUpdatePhoto(pref.getAuth(), part)
                update.postValue(result)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            update.postValue(Resource.Error("An error occurred"))
        }
    }
}