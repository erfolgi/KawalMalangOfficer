package com.kawal.malang.officer.presentation.menus

import com.kawal.malang.citizen.model.response.pengaduan.agenda.AgendaItem
import com.kawal.malang.officer.data.api.ApiCall
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem
import com.kawal.malang.officer.presentation.di.ApiClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenusPresenter(private val contract: MenusContract, private var auth:String) {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)

    fun loadAgenda(page:Int?) {
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
                            contract.onLoadAgenda(body.data)
                        }else{
                            contract.onLoadAgenda(arrayListOf())
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

    fun loadGiat(page:Int?) {
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
                            contract.onLoadGiat(body.data)
                        }else{
                            contract.onLoadGiat(arrayListOf())
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