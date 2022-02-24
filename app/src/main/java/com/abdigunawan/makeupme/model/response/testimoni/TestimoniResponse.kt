package com.abdigunawan.makeupme.model.response.testimoni


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TestimoniResponse(
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("testimoni")
    val testimoni: Testimoni,
    @Expose
    @SerializedName("0")
    val x0: Int
)