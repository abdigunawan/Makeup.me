package com.abdigunawan.makeupme.model.response.testimoni


import com.google.gson.annotations.SerializedName

data class Testimoni(
    @SerializedName("catatan")
    val catatan: String,
    @SerializedName("gambar")
    val gambar: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("id_konfirmasitransaksi")
    val idKonfirmasitransaksi: Int,
    @SerializedName("id_tukang")
    val idTukang: Int,
    @SerializedName("id_user")
    val idUser: Int,
    @SerializedName("tanggal_testimoni")
    val tanggalTestimoni: String
)