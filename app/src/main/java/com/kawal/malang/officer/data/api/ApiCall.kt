package com.kawal.malang.officer.data.api

import com.kawal.malang.citizen.model.response.pengaduan.KategoriPengaduanItem
import com.kawal.malang.citizen.model.response.pengaduan.agenda.AgendaItem
import com.kawal.malang.citizen.model.response.pengaduan.lokasi.LokasiItem
import com.kawal.malang.officer.data.model.BaseResponse
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData
import com.kawal.malang.officer.data.model.pengaduan.PengaduanItem
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem
import com.kawal.malang.officer.data.model.pengaduan.giat.KomentarItem
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiCall {
    @POST("riwayat-lokasi")
    fun recordCarPositionCall(
        @Header("Authorization") token: String,
        @Body body: Map<String, String>
    ): Call<BaseResponse<LocationHistoryData>>


    //region Pengaduan
    @GET("agenda-kapolres")
    fun getAgenda(
        @Header("authorization") authorization: String?,
        @Query("page") page: Int?
    ): Call<PostResponse<ArrayList<AgendaItem>>>

    @GET("agenda-kapolres/{id}")
    fun showAgenda(
        @Header("authorization") authorization: String?,
        @Path(value = "id", encoded = true) id:Int
    ): Call<PostResponse<AgendaItem>>


    @Multipart
    @POST("giat")
    fun postGiat(
        @Header("authorization") authorization: String?,
        @Part foto: MultipartBody.Part?,
        @PartMap map: Map<String, @JvmSuppressWildcards RequestBody>
    ): Call<PostResponse<GiatItem>>

    @Multipart
    @POST("giat/{id}?_method=PUT")
    fun updateGiat(
        @Header("authorization") authorization: String?,
        @Path(value = "id", encoded = true) id:Int,
        @Part foto: MultipartBody.Part?,
        @PartMap map: Map<String, @JvmSuppressWildcards RequestBody>
    ): Call<PostResponse<GiatItem>>

    @GET("giat")
    fun getGiat(
        @Header("authorization") authorization: String?,
        @Query("page") page: Int?
    ): Call<PostResponse<ArrayList<GiatItem>>>

    @GET("giat/{id}")
    fun showGiat(
        @Header("authorization") authorization: String?,
        @Path(value = "id", encoded = true) id:Int
    ): Call<PostResponse<GiatItem>>

    @POST("giat/{id}/komentar")
    @FormUrlEncoded
    fun postGiatKomentar(
        @Header("authorization") authorization: String?,
        @Path(value = "id", encoded = true) id:Int,
        @Field("komentar") komentar: String?
    ): Call<PostResponse<KomentarItem>>

    @POST("giat/{id}/komentar/{komentar}?_method=Delete")
    fun deleteGiatKomentar(
        @Header("authorization") authorization: String?,
        @Path(value = "id", encoded = true) id:Int,
        @Path(value = "komentar", encoded = true) komentar:Int

    ): Call<PostResponse<KomentarItem>>


    @GET("data/kategori-lokasi")
    fun getKategoriLokasi(
        @Header("authorization") authorization: String?
    ): Call<ArrayList<KategoriPengaduanItem>>

    @GET("data/kategori-pengaduan")
    fun getKategoriPengaduan(
        @Header("authorization") authorization: String?,
        @Query("parent_id") parent_id: Int?,
    ): Call<ArrayList<KategoriPengaduanItem>>

    @GET("lokasi")
    fun getLokasi(
        @Header("authorization") authorization: String?,
        @Query("last_id") last_id: Int?,
        @Query("nama") nama: String?,
        @Query("kategori_id") kategori_id: Int?,
        @Query("latitude") latitude: Double?,
        @Query("longitude") longitude: Double?
    ): Call<PostResponse<ArrayList<LokasiItem>>>

    @GET("pengaduan")
    fun getPengaduan(
        @Header("authorization") authorization: String?,
        @Query("last_id") last_id: Int?,
        @Query("judul") judul: String?=null,
        @Query("kategori_id") kategori_id: Int?=null,
        @Query("sub_kategori_id") sub_kategori_id: Int?=null,
        @Query("status") status: String?=null,
        @Query("tanggal") tanggal: String?=null
    ): Call<PostResponse<ArrayList<PengaduanItem>>>

    @GET("pengaduan/{id}")
    fun showPengaduan(
        @Header("authorization") authorization: String?,
        @Path(value = "id", encoded = true) id:Int
    ): Call<PostResponse<PengaduanItem>>

    @GET("pengaduan/{id}?_method=DELETE")
    fun deletePengaduan(
        @Header("authorization") authorization: String?,
        @Path(value = "id", encoded = true) id:Int
    ): Call<PostResponse<PengaduanItem>>

    @Multipart
    @POST("pengaduan")
    fun postPengaduan(
        @Header("authorization") authorization: String?,
        @Part foto: MultipartBody.Part?,
        @PartMap map: Map<String, @JvmSuppressWildcards RequestBody>
    ): Call<PostResponse<PengaduanItem>>

    @Multipart
    @POST("pengaduan/{id}?_method=PUT")
    fun updatePengaduan(
        @Header("authorization") authorization: String?,
        @Path(value = "id", encoded = true) id:Int,
        @Part foto: MultipartBody.Part?,
        @PartMap map: Map<String, @JvmSuppressWildcards RequestBody>
    ): Call<PostResponse<PengaduanItem>>

    @GET("giat/{id}?_method=DELETE")
    fun deleteGiat(
        @Header("authorization") authorization: String?,
        @Path(value = "id", encoded = true) id:Int
    ): Call<PostResponse<GiatItem>>
    //endregion Pengaduan
}