package com.kawal.malang.officer.presentation.agenda.detail


import com.kawal.malang.citizen.model.response.pengaduan.agenda.AgendaItem
import com.kawal.malang.officer.data.api.ApiCall
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.presentation.agenda.detail.DetailAgendaContract
import com.kawal.malang.officer.presentation.di.ApiClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailAgendaPresenter (private val contract: DetailAgendaContract, private val auth:String) {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)

    fun loadAgenda(id:Int) {
        client.showAgenda(auth,id).enqueue(object:
            Callback<PostResponse<AgendaItem>> {
            override fun onResponse(
                call: Call<PostResponse<AgendaItem>>,
                response: Response<PostResponse<AgendaItem>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: PostResponse<AgendaItem>? = response.body()
                        if (body?.data != null ) {
                            contract.onLoad(body.data)
                        }else{
                            contract.onLoad(AgendaItem())
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

            override fun onFailure(call: Call<PostResponse<AgendaItem>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")

            }
        })
    }
}