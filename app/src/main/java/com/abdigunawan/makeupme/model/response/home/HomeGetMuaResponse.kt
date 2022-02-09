package com.abdigunawan.makeupme.model.response.home


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeGetMuaResponse(
    @Expose
    @SerializedName("kota")
    val kota: List<Kota>,
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("0")
    val x0: Int
)