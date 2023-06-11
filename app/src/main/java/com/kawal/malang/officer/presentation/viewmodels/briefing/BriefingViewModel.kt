package com.kawal.malang.officer.presentation.viewmodels.briefing

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.core.util.Resource
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.briefing.BriefingData
import com.kawal.malang.officer.data.model.panic.report.CategoryData
import com.kawal.malang.officer.domain.usecase.briefing.BriefingUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class BriefingViewModel (private val app: Application,
private val useCase: BriefingUseCase
): AndroidViewModel(app) {
    val briefingData: MutableLiveData<Resource<ArrayList<BriefingData>>> = MutableLiveData()
    val categories: MutableLiveData<Resource<ArrayList<CategoryData>>> = MutableLiveData()
    val paginate: MutableLiveData<Resource<ArrayList<BriefingData>>> = MutableLiveData()
    val postData: MutableLiveData<Resource<BaseResponse<BriefingData>>> = MutableLiveData()
    val detail: MutableLiveData<Resource<BriefingData>> = MutableLiveData()

    private val pref = AppPreference(app.applicationContext)
    fun getBriefingCategory() = viewModelScope.launch(Dispatchers.IO) {
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

    fun filterBriefingList(
        lastId: String = "",
        category: String = "",
        tanggal: String = "",
        judul: String = "") = viewModelScope.launch(Dispatchers.IO) {
        briefingData.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetBriefing(pref.getAuth(), lastId, category,tanggal,judul)
                briefingData.postValue(result)
            } else briefingData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            briefingData.postValue(Resource.Error("An error occurred"))
        }
    }

    fun getBriefingList() = viewModelScope.launch(Dispatchers.IO) {
        briefingData.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetBriefing(pref.getAuth())
                briefingData.postValue(result)
            } else briefingData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            briefingData.postValue(Resource.Error("An error occurred"))
        }
    }

    fun getDetailBriefing(id: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetDetail(pref.getAuth(), id)
                detail.postValue(result)
            } else detail.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            detail.postValue(Resource.Error("An error occurred"))
        }
    }


    fun refreshBriefingList() = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetBriefing(pref.getAuth())
                briefingData.postValue(result)
            } else briefingData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            briefingData.postValue(Resource.Error("An error occurred"))
        }
    }

    fun paginateBriefingList(lastId: String, category: String, title: String = "") = viewModelScope.launch(Dispatchers.IO) {
        paginate.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execGetBriefing(pref.getAuth(), lastId, category, title)
                paginate.postValue(result)
            } else paginate.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            paginate.postValue(Resource.Error("An error occurred"))
        }
    }

    fun createBriefing(body: Map<String, RequestBody>, file: File) = viewModelScope.launch(Dispatchers.IO) {
        postData.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val reqFile = RequestBody.create(MediaType.parse("image/*"), file)
                val part = MultipartBody.Part.createFormData("foto", file.name, reqFile)
                val result = useCase.execCreate(pref.getAuth(), body, part)
                postData.postValue(result)
            } else postData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            postData.postValue(Resource.Error("An error occurred"))
        }
    }

    fun updateBriefing(id: String, body: Map<String, RequestBody>, file: File? = null) = viewModelScope.launch(Dispatchers.IO) {
        postData.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                if (file != null) {
                    val reqFile = RequestBody.create(MediaType.parse("image/*"), file)
                    val part = MultipartBody.Part.createFormData("foto", file.name, reqFile)
                    val result = useCase.execUpdate(pref.getAuth(), id, body, part)
                    postData.postValue(result)
                } else {
                    val result = useCase.execUpdate(pref.getAuth(), id, body, null)
                    postData.postValue(result)
                }
            } else postData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            postData.postValue(Resource.Error("An error occurred"))
        }
    }

    fun deleteBriefing(id: String) = viewModelScope.launch(Dispatchers.IO) {
        postData.postValue(Resource.Loading())
        try {
            if (AppUtil.isNetworkAvailable(app.applicationContext)) {
                val result = useCase.execDelete(pref.getAuth(), id)
                postData.postValue(result)
            } else postData.postValue(Resource.NetworkError("Turn on your connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            postData.postValue(Resource.Error("An error occurred"))
        }
    }
}