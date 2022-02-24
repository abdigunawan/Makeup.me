package com.abdigunawan.makeupme.model.response.orderkonfirmasi


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OrderKonfirmasiTransaksiResponse(
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("transaksiuser")
    val transaksiuser: List<Transaksiuser>
): Serializable