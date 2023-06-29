package com.kawal.malang.officer.presentation.giat


import com.kawal.malang.officer.data.api.ApiCall
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem
import com.kawal.malang.officer.presentation.di.ApiClient
import com.kawal.malang.officer.presentation.giat.GiatContract
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GiatPresenter(private val contract: GiatContract, private var auth:String) {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)

    fun load(page:Int?) {
        client.getGiat(auth,page).enqueue(object:
            Callback<PostResponse<ArrayList<GiatItem>>> {
            override fun onResponse(
                call: Call<PostResponse<ArrayList<GiatItem>>>,
                response: Response<PostResponse<ArrayList<GiatItem>>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: PostResponse<ArrayList<GiatItem>>? = response.body()
                        if (body?.status==true && !body.data.isNullOrEmpty()) {
                            contract.onLoad(body.data)
                        }else{
                            contract.onLoad(arrayListOf())
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

            override fun onFailure(call: Call<PostResponse<ArrayList<GiatItem>>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")

            }
        })
    }
}