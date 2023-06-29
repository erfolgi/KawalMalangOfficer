package com.kawal.malang.officer.presentation.pengaduan

import com.kawal.malang.citizen.model.response.pengaduan.KategoriPengaduanItem
import com.kawal.malang.officer.data.api.ApiCall
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.data.model.pengaduan.PengaduanItem
import com.kawal.malang.officer.presentation.di.ApiClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PengaduanPresenter (private val contract: PengaduanContract, private val auth:String) {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)
    fun loadPengaduan(lastId:Int?, nama:String?, kategori_id:Int?, subkategori_id:Int?, status:String?, tanggal:String?) {
        client.getPengaduan(auth,lastId,nama,kategori_id, subkategori_id, status, tanggal).enqueue(object:
            Callback<PostResponse<ArrayList<PengaduanItem>>> {
            override fun onResponse(
                call: Call<PostResponse<ArrayList<PengaduanItem>>>,
                response: Response<PostResponse<ArrayList<PengaduanItem>>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: PostResponse<ArrayList<PengaduanItem>>? = response.body()
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

            override fun onFailure(call: Call<PostResponse<ArrayList<PengaduanItem>>>, t: Throwable) {
                contract.onFailedMessage("Unknown Error: $t")

            }
        })
    }

    fun loadKategori(parent_id:Int?=-1) {
        client.getKategoriPengaduan(auth,parent_id).enqueue(object:
            Callback<ArrayList<KategoriPengaduanItem>> {
            override fun onResponse(
                call: Call<ArrayList<KategoriPengaduanItem>>,
                response: Response<ArrayList<KategoriPengaduanItem>>
            ) {
                when(response.code()){
                    200 -> {
                        val body: ArrayList<KategoriPengaduanItem>? = response.body()
                        if (body != null) {
                            contract.onLoadKategori(body,parent_id==-1)
                        }else{
                            contract.onLoadKategori(arrayListOf(),parent_id==-1)
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