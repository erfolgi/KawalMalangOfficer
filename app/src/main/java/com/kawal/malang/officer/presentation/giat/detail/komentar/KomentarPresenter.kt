package com.kawal.malang.officer.presentation.giat.detail.komentar


import com.kawal.malang.officer.data.api.ApiCall
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.data.model.pengaduan.giat.KomentarItem
import com.kawal.malang.officer.presentation.di.ApiClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KomentarPresenter(private val contract: KomentarContract, private val auth:String, private val giatId:Int) {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)

    fun postKomentar(komentar:String) {
        client.postGiatKomentar(auth, giatId, komentar).enqueue(object:
            Callback<PostResponse<KomentarItem>> {
            override fun onResponse(
                call: Call<PostResponse<KomentarItem>>,
                response: Response<PostResponse<KomentarItem>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: PostResponse<KomentarItem>? = response.body()
                        if (body != null) {
                            if(body.data!=null){
                                contract.onSubmit(body.data);
                            }else{
                                body.message?.let { contract.onFailedMessage(it) }
                            }
                        }else{
                            try{
                                val jObjError =
                                    JSONObject(response.errorBody()!!.string())
                                contract.onFailedMessage(jObjError.getString("message"))
                            }catch(e:Exception){
                                contract.onFailedMessage(response.message())
                            }
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

            override fun onFailure(call: Call<PostResponse<KomentarItem>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")

            }
        })
    }
    fun deleteKomentar(komentarId:Int) {
        client.deleteGiatKomentar(auth, giatId, komentarId).enqueue(object:
            Callback<PostResponse<KomentarItem>> {
            override fun onResponse(
                call: Call<PostResponse<KomentarItem>>,
                response: Response<PostResponse<KomentarItem>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: PostResponse<KomentarItem>? = response.body()
                        if (body != null) {
                            if(body.data!=null){
                                contract.onDelete(body);
                            }else{
                                body.message?.let { contract.onFailedMessage(it) }
                            }
                        }else{
                            try{
                                val jObjError =
                                    JSONObject(response.errorBody()!!.string())
                                contract.onFailedMessage(jObjError.getString("message"))
                            }catch(e:Exception){
                                contract.onFailedMessage(response.message())
                            }
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

            override fun onFailure(call: Call<PostResponse<KomentarItem>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")

            }
        })
    }
}