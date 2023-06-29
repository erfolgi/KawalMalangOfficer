package com.kawal.malang.officer.presentation.giat.form

import com.google.gson.Gson
import com.kawal.malang.officer.core.util.Util
import com.kawal.malang.officer.core.util.Util.toMap
import com.kawal.malang.officer.data.api.ApiCall
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatForm
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem
import com.kawal.malang.officer.presentation.di.ApiClient
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.lang.Exception

class FormGiatPresenter(private val contract: FormGiatContract, private var auth:String) {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)
    fun postGiat(data: GiatForm, foto: File?) {
        var f1: MultipartBody.Part?  = foto?.let { Util.prepareFilePart(it,"foto") }

        val jsonObj = JSONObject(Gson().toJson(data))
        var map = jsonObj.toMap()
        val mapX: HashMap<String, RequestBody> = HashMap()
        for ((key, value) in map) {
            mapX[key] = Util.reqBody(value.toString())
        }

        client.postGiat(auth,f1,mapX).enqueue(object:
            Callback<PostResponse<GiatItem>> {
            override fun onResponse(
                call: Call<PostResponse<GiatItem>>,
                response: Response<PostResponse<GiatItem>>
            ) {
                when(response.code()){
                    200 -> {
                        if (response.body()?.status ==true){
                            val body: PostResponse<GiatItem>? = response.body()
                            if (body?.status ==true) {
                                contract.onSubmit(body.message!!, body.data!!)
                            }else{
                                contract.onFailedMessage(body!!.message!!)
                            }
                        }else{
                            contract.onFailedMessage(response.body()!!.message!!)
                        }
                    }
                    else->{
                        try{
                            val jObjError =
                                JSONObject(response.errorBody()!!.string())
                            contract.onFailedMessage(jObjError.getString("message"))
                        }catch (e: Exception){
                            contract.onFailedMessage(response.message())
                        }

                    }
                }
            }

            override fun onFailure(call: Call<PostResponse<GiatItem>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")

            }
        })
    }

    fun updateGiat(id:Int, data: GiatForm, foto: File?) {
        var f1: MultipartBody.Part?  = foto?.let { Util.prepareFilePart(it,"foto") }

        val jsonObj = JSONObject(Gson().toJson(data))
        var map = jsonObj.toMap()
        val mapX: HashMap<String, RequestBody> = HashMap()
        for ((key, value) in map) {
            mapX[key] = Util.reqBody(value.toString())
        }

        client.updateGiat(auth,id,f1,mapX).enqueue(object:
            Callback<PostResponse<GiatItem>> {
            override fun onResponse(
                call: Call<PostResponse<GiatItem>>,
                response: Response<PostResponse<GiatItem>>
            ) {
                when(response.code()){
                    200 -> {
                        if (response.body()?.status ==true){
                            val body: PostResponse<GiatItem>? = response.body()
                            if (body?.status ==true) {
                                contract.onSubmit(body.message!!, body.data!!)
                            }else{
                                contract.onFailedMessage(body!!.message!!)
                            }
                        }else{
                            contract.onFailedMessage(response.body()!!.message!!)
                        }
                    }
                    else->{
                        try{
                            val jObjError =
                                JSONObject(response.errorBody()!!.string())
                            contract.onFailedMessage(jObjError.getString("message"))
                        }catch (e: Exception){
                            contract.onFailedMessage(response.message())
                        }

                    }
                }
            }

            override fun onFailure(call: Call<PostResponse<GiatItem>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")

            }
        })
    }

}