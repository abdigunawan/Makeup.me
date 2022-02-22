package com.abdigunawan.makeupme.network

import com.abdigunawan.makeupme.model.response.editpassword.EditPasswordResponse
import com.abdigunawan.makeupme.model.response.editprofil.EditProfilResponse
import com.abdigunawan.makeupme.model.response.editprofil.Ubahprofile
import com.abdigunawan.makeupme.model.response.home.HomeGetMuaResponse
import com.abdigunawan.makeupme.model.response.home.paket.MuaPaketResponse
import com.abdigunawan.makeupme.model.response.home.transaksi.HomeTransaksiResponse
import com.abdigunawan.makeupme.model.response.login.LoginResponse
import com.abdigunawan.makeupme.model.response.login.X0
import com.abdigunawan.makeupme.model.response.logout.LogOutResponse
import com.abdigunawan.makeupme.model.response.saran.BeriMasukanResponse
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*


interface Endpoint {

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email")email:String,
              @Field("password")password:String) : Observable<LoginResponse<X0>>

    @Multipart
    @POST("registeruser")
    fun register(
        @Part("name") name: RequestBody,
        @Part("email") email: RequestBody,
        @Part("password") password: RequestBody,
        @Part("no_hp") no_hp: RequestBody,
        @Part("alamat") alamat: RequestBody,
        @Part("no_rumah") no_rumah: RequestBody,
        @Part("kota") kota: RequestBody,
        @Part gambar: MultipartBody.Part?,
        @Part("roles") roles: RequestBody?
    ): Observable<LoginResponse<X0>>

    @POST("logout")
    fun logout() : Observable<LogOutResponse>

    @GET("user/produk/get")
    fun getproduk() : Observable<HomeGetMuaResponse>

    @GET("user/produk/paket/{id}")
    fun getpaketmua(@Path(value = "id") muaId:String) : Observable<MuaPaketResponse>

    @GET("user/produk/get/testimoni/{id}")
    fun gettestimoni(@Path(value = "id") id_paket: String)

    @GET("user/produk/get/jadwal/{id}")
    fun getjadwal(@Path(value = "id") id_paket: String)

    @FormUrlEncoded
    @POST("user/transaksi/{id}")
    fun transaksipaket(
        @Path(value = "id") paketId:String,
        @Field("jumlah")jumlah:String,
        @Field("tanggal_acara")tanggalacara:String,
        @Field("jam_acara")jamacara:String,
        @Field("catatan")catatan:String,
    ) : Observable<HomeTransaksiResponse>

    @Multipart
    @POST("ubahprofileuser/{id}")
    fun editprofil(
        @Path(value = "id") userid:String,
        @Part("name") name: RequestBody,
        @Part("email") email: RequestBody,
        @Part("no_hp") no_hp: RequestBody,
        @Part("alamat") alamat: RequestBody,
        @Part("no_rumah") no_rumah: RequestBody,
        @Part("kota") kota: RequestBody,
        @Part gambar: MultipartBody.Part?,
        @Part("roles") roles: RequestBody?
    ): Observable<EditProfilResponse<Ubahprofile>>

    @FormUrlEncoded
    @POST("ubahpassword")
    fun editpassword(@Field("passwordlama")passwordlama:String,
              @Field("passwordbaru")passwordbaru:String,
              @Field("passwordkonfirmasi")passwordkonfirmasi:String) : Observable<EditPasswordResponse>

    @FormUrlEncoded
    @POST("saran")
    fun saran(@Field("id_user")id_user:String?,
                     @Field("saran")saran:String) : Observable<BeriMasukanResponse>

}