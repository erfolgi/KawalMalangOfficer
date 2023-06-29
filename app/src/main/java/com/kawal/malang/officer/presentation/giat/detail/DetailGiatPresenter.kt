package com.kawal.malang.officer.presentation.giat.detail


import com.kawal.malang.officer.data.api.ApiCall
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem
import com.kawal.malang.officer.presentation.di.ApiClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailGiatPresenter(private val contract: DetailGiatContract, private val auth:String) {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)

    fun loadGiat(id:Int) {
        client.showGiat(auth,id).enqueue(object:
            Callback<PostResponse<GiatItem>> {
            override fun onResponse(
                call: Call<PostResponse<GiatItem>>,
                response: Response<PostResponse<GiatItem>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: PostResponse<GiatItem>? = response.body()
                        if (body?.data != null ) {
                            contract.onLoad(body.data)
                        }else{
                            contract.onLoad(GiatItem())
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

            override fun onFailure(call: Call<PostResponse<GiatItem>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")
            }
        })
    }

    fun deleteGiat(id:Int) {
        client.deleteGiat(auth,id).enqueue(object:
            Callback<PostResponse<GiatItem>>{
            override fun onResponse(
                call: Call<PostResponse<GiatItem>>,
                response: Response<PostResponse<GiatItem>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: PostResponse<GiatItem>? = response.body()
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

            override fun onFailure(call: Call<PostResponse<GiatItem>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")
            }
        })
    }
    
}