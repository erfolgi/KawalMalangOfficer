package com.kawal.malang.officer.presentation.pengaduan.detail

import com.kawal.malang.officer.data.api.ApiCall
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.data.model.pengaduan.PengaduanItem
import com.kawal.malang.officer.presentation.di.ApiClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPengaduanPresenter(private val contract: DetailPengaduanContract, private val auth:String) {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)
    fun loadPengaduan(id:Int) {
        client.showPengaduan(auth,id).enqueue(object:
            Callback<PostResponse<PengaduanItem>> {
            override fun onResponse(
                call: Call<PostResponse<PengaduanItem>>,
                response: Response<PostResponse<PengaduanItem>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: PostResponse<PengaduanItem>? = response.body()
                        if (body?.data != null ) {
                            contract.onLoad(body.data)
                        }else{
                            contract.onLoad(PengaduanItem())
                        }
                    }
                    else->{
                        try{
                            val jObjError =
                                JSONObject(response.errorBody()!!.string())
                            contract.onFailedMessage(jObjError.getString("message"))
                        }catch(e:Exception){
                            contract.onFailedMessage(response.message())
                        }

                    }
                }
            }

            override fun onFailure(call: Call<PostResponse<PengaduanItem>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")

            }
        })
    }

    fun deletePengaduan(id:Int) {
        client.deletePengaduan(auth,id).enqueue(object:
            Callback<PostResponse<PengaduanItem>> {
            override fun onResponse(
                call: Call<PostResponse<PengaduanItem>>,
                response: Response<PostResponse<PengaduanItem>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: PostResponse<PengaduanItem>? = response.body()
                        body?.message?.let { contract.onDelete(it) }

                    }
                    else->{
                        try{
                            val jObjError =
                                JSONObject(response.errorBody()!!.string())
                            contract.onFailedMessage(jObjError.getString("message"))
                        }catch(e:Exception){
                            contract.onFailedMessage(response.message())
                        }

                    }
                }
            }

            override fun onFailure(call: Call<PostResponse<PengaduanItem>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")

            }
        })
    }
}