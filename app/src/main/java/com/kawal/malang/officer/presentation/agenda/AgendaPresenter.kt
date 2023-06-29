package com.kawal.malang.officer.presentation.agenda

import com.kawal.malang.citizen.model.response.pengaduan.agenda.AgendaItem
import com.kawal.malang.officer.data.api.ApiCall
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.presentation.di.ApiClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AgendaPresenter(private val contract: AgendaContract, private var auth:String) {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)
    fun load(page:Int?) {
        client.getAgenda(auth,page).enqueue(object:
            Callback<PostResponse<ArrayList<AgendaItem>>> {
            override fun onResponse(
                call: Call<PostResponse<ArrayList<AgendaItem>>>,
                response: Response<PostResponse<ArrayList<AgendaItem>>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: PostResponse<ArrayList<AgendaItem>>? = response.body()
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

            override fun onFailure(call: Call<PostResponse<ArrayList<AgendaItem>>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")

            }
        })
    }
}