package com.abdigunawan.makeupme.model.response.order


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RiwayatTransaksiResponse(
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("transaksiuser")
    val transaksiuser: List<Transaksiuser>
)