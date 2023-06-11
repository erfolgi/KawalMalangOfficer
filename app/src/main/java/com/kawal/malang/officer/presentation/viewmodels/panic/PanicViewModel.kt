package com.kawal.malang.officer.presentation.viewmodels.panic

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.panic.report.CategoryData
import com.kawal.malang.officer.data.model.panic.report.PanicCarData
import com.kawal.malang.officer.data.model.panic.report.PanicReportData
import com.kawal.malang.officer.domain.usecase.panic.PanicUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PanicViewModel(
    private val app: Application,
    private val useCase: PanicUseCase
): AndroidViewModel(app) {
    val panicReportData: MutableLiveData<Resource<ArrayList<PanicReportData>>> = MutableLiveData()
    val paginate: MutableLiveData<Resource<ArrayList<PanicReportData>>> = MutableLiveData()
    val categories: MutableLiveData<Resource<ArrayList<CategoryData>>> = MutableLiveData()
    val panicDetail: MutableLiveData<Resource<PanicReportData>> = MutableLiveData()
    val respond: MutableLiveData<Resource<BaseResponse<PanicCarData>>> = MutableLiveData()
    val finishPanic: MutableLiveData<Resource<BaseResponse<PanicReportData>>> = MutableLiveData()
    private val pref = AppPreference(app.applicationContext)

    fun getPanicReport() = viewModelScope.launch(Dispatchers.IO) {
        panicReportData.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetPanic(pref.getAuth())
                panicReportData.postValue(result)
            } else panicReportData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            panicReportData.postValue(Resource.Error("An error occurred"))
        }
    }

    fun getAroundPanic(latitude: Double, longitude: Double) = viewModelScope.launch(Dispatchers.IO) {
        panicReportData.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetAroundPanic(pref.getAuth(), latitude, longitude)
                panicReportData.postValue(result)
            } else panicReportData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            panicReportData.postValue(Resource.Error("An error occurred"))
        }
    }

    fun refreshAroundPanic(latitude: Double, longitude: Double) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetAroundPanic(pref.getAuth(), latitude, longitude)
                panicReportData.postValue(result)
            } else panicReportData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            panicReportData.postValue(Resource.Error("An error occurred"))
        }
    }

    fun getPanicCategory() = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetCategory(pref.getAuth())
                categories.postValue(result)
            } else categories.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            categories.postValue(Resource.Error("An error occurred"))
        }
    }

    fun getActivatedPanic(latitude: Double, longitude: Double) = viewModelScope.launch(Dispatchers.IO) {
        finishPanic.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetActivatedPanic(pref.getAuth(), latitude, longitude)
                finishPanic.postValue(result)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            finishPanic.postValue(Resource.Error("An error occurred"))
        }
    }

    fun filterPanicReport(
        category: String = "",
        startDate: String = "",
        endDate: String = "") = viewModelScope.launch(Dispatchers.IO) {
        panicReportData.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetPanic(pref.getAuth(), category, startDate, endDate)
                panicReportData.postValue(result)
            } else panicReportData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            panicReportData.postValue(Resource.Error("An error occurred"))
        }
    }

    fun refreshPanicReport() = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetPanic(pref.getAuth())
                panicReportData.postValue(result)
            } else panicReportData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            panicReportData.postValue(Resource.Error("An error occurred"))
        }
    }

    fun paginatePanicReport(
        categoryId: String = "",
        lastId: String = "",
        startDate: String = "",
        endDate: String = "") = viewModelScope.launch((Dispatchers.IO)) {
        paginate.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetPanic(pref.getAuth(), categoryId, lastId, startDate, endDate)
                paginate.postValue(result)
            } else paginate.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            paginate.postValue(Resource.Error("An error occurred"))
        }
    }

    fun refreshPanicDetail(id: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetPanicDetail(pref.getAuth(), id)
                panicDetail.postValue(result)
            } else panicDetail.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            panicDetail.postValue(Resource.Error("An error occurred"))
        }
    }

    fun respondToPanic(panicId: String) = viewModelScope.launch(Dispatchers.IO) {
        respond.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execPanicRespond(pref.getAuth(), panicId)
                respond.postValue(result)
            } else respond.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            respond.postValue(Resource.Error("An error occurred"))
        }
    }

    fun finishPanic(panicId: String) =
        viewModelScope.launch(Dispatchers.IO) {
            finishPanic.postValue(Resource.Loading())
            try {
                if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                    val result = useCase.execFinishPanic(pref.getAuth(), panicId)
                    finishPanic.postValue(result)
                } else finishPanic.postValue(Resource.NetworkError("Turn on your connection"))
            } catch (e: Exception) {
                e.printStackTrace()
                finishPanic.postValue(Resource.Error("An error occurred"))
            }
        }
}