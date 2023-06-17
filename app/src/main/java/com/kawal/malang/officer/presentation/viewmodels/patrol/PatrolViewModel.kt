package com.kawal.malang.officer.presentation.viewmodels.patrol

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.auth.MemberData
import com.kawal.malang.officer.data.model.panic.report.PatrolData
import com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData
import com.kawal.malang.officer.domain.usecase.patrol.PatrolUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PatrolViewModel(
    private val app: Application,
    private val useCase: PatrolUseCase
): AndroidViewModel(app) {
    val members: MutableLiveData<Resource<ArrayList<MemberData>>> = MutableLiveData()
    val doPatrolData: MutableLiveData<Resource<BaseResponse<PatrolData>>> = MutableLiveData()
    val history: MutableLiveData<Resource<ArrayList<PatrolData>>> = MutableLiveData()
    val record: MutableLiveData<Resource<BaseResponse<LocationHistoryData>>> = MutableLiveData()
    private val pref = AppPreference(app.applicationContext)

    fun getMembers(search: String = "") = viewModelScope.launch(Dispatchers.IO) {
        members.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetMembers(pref.getAuth(), search)
                members.postValue(result)
            } else members.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            members.postValue(Resource.Error("An error occurred"))
        }
    }








    fun recordPosition(body: Map<String, String>) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execRecordPosition(pref.getAuth(), body)
                record.postValue(result)
            } else record.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            record.postValue(Resource.Error("An error occurred"))
        }
    }
}