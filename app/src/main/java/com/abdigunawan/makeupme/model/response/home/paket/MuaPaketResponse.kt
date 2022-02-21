package com.abdigunawan.makeupme.model.response.home.paket


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MuaPaketResponse(
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("paket")
    val paket: List<Paket>,
    @Expose
    @SerializedName("0")
    val x0: Int
)