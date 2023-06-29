package com.kawal.malang.officer.presentation.lokasi

import com.kawal.malang.citizen.model.response.pengaduan.KategoriPengaduanItem
import com.kawal.malang.citizen.model.response.pengaduan.lokasi.LokasiItem
import com.kawal.malang.officer.data.api.ApiCall
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.presentation.di.ApiClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LokasiPresenter  (private val contract: LokasiContract, private val auth:String) {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)
    fun loadLokasi(lastId:Int?, kategori_id:Int?,nama:String?, latitude:Double?, longitude:Double?) {
        client.getLokasi(auth,lastId,nama,kategori_id,latitude, longitude).enqueue(object:
            Callback<PostResponse<ArrayList<LokasiItem>>> {
            override fun onResponse(
                call: Call<PostResponse<ArrayList<LokasiItem>>>,
                response: Response<PostResponse<ArrayList<LokasiItem>>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: PostResponse<ArrayList<LokasiItem>>? = response.body()
                        if (body != null && !body.data.isNullOrEmpty()) {
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

            override fun onFailure(call: Call<PostResponse<ArrayList<LokasiItem>>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")
                
            }
        })
    }

    fun loadKategori() {
        client.getKategoriLokasi(auth).enqueue(object:
            Callback<ArrayList<KategoriPengaduanItem>> {
            override fun onResponse(
                call: Call<ArrayList<KategoriPengaduanItem>>,
                response: Response<ArrayList<KategoriPengaduanItem>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: ArrayList<KategoriPengaduanItem>? = response.body()
                        if (body != null) {
                            contract.onLoadKategori(body)
                        }else{
                            contract.onLoadKategori(arrayListOf())
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

            override fun onFailure(call: Call<ArrayList<KategoriPengaduanItem>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")

            }
        })
    }
}