package com.abdigunawan.makeupme.model.response.home.testimoni


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Testimoni(
    @Expose
    @SerializedName("catatan")
    val catatan: String,
    @Expose
    @SerializedName("gambar")
    val gambar: String,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("id_konfirmasitransaksi")
    val idKonfirmasitransaksi: Int,
    @Expose
    @SerializedName("id_tukang")
    val idTukang: Int,
    @Expose
    @SerializedName("id_user")
    val idUser: Int,
    @Expose
    @SerializedName("tanggal_testimoni")
    val tanggalTestimoni: String,
    @Expose
    @SerializedName("user")
    val user: User
)