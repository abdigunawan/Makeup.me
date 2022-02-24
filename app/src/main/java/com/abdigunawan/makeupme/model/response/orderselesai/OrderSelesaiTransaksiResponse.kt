package com.abdigunawan.makeupme.model.response.orderselesai


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OrderSelesaiTransaksiResponse(
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("transaksiuser")
    val transaksiuser: List<Transaksiuser>
): Serializable