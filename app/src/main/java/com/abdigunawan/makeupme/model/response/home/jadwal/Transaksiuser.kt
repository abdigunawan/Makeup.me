package com.abdigunawan.makeupme.model.response.home.jadwal


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Transaksiuser(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deskripsi")
    val deskripsi: String,
    @Expose
    @SerializedName("foto")
    val foto: String,
    @SerializedName("harga")
    val harga: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("id_user")
    val idUser: Int,
    @Expose
    @SerializedName("nama_paket")
    val namaPaket: String,
    @Expose
    @SerializedName("produk")
    val produk: String,
    @SerializedName("updated_at")
    val updatedAt: String
)