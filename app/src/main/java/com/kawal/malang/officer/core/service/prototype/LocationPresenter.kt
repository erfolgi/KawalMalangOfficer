package com.kawal.malang.officer.core.service.prototype

import android.util.Log
import com.kawal.malang.officer.data.api.ApiCall
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData
import com.kawal.malang.officer.presentation.di.ApiClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class LocationPresenter() {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)
    var TAG = "LocationServiceX"

    fun postUpdateLokasi(auth:String,lat:Double?,long:Double?){
        val body = hashMapOf<String, String>()
        body["latitude"] = "$lat"
        body["longitude"] = "$long"

        client.recordCarPositionCall(auth,body).enqueue(object:
            Callback<BaseResponse<LocationHistoryData>> {
            override fun onResponse(
                call: Call<BaseResponse<LocationHistoryData>>,
                response: Response<BaseResponse<LocationHistoryData>>
            ) {
                when(response.code()){
                    200 -> {val body: BaseResponse<LocationHistoryData>? = response.body()
                        if (body != null) {
                            Log.d(TAG,body.message.toString())
                        }
                    }
                    else->{
                        try{
                            val jObjError =
                                JSONObject(response.errorBody()!!.string())
                            Log.d(TAG,jObjError.getString("message"))
                        }catch(e:Exception){
                            Log.d(TAG,response.message())
                        }

                    }
                }
            }

            override fun onFailure(call: Call<BaseResponse<LocationHistoryData>>, t: Throwable) {
                Log.d(TAG," FAILED $t")
            }

        })
    }
}