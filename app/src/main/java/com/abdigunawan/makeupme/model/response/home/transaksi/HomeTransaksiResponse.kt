package com.abdigunawan.makeupme.model.response.home.transaksi


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeTransaksiResponse(
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("transaksi")
    val transaksi: Transaksi,
    @Expose
    @SerializedName("0")
    val x0: Int
)