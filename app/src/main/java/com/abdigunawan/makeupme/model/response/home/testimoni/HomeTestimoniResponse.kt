package com.abdigunawan.makeupme.model.response.home.testimoni


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeTestimoniResponse(
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("testimoni")
    val testimoni: List<Testimoni>
)