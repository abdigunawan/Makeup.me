package com.abdigunawan.makeupme.model.response.home.jadwal


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeJadwalResponse(
    @Expose
    @SerializedName("jadwal")
    val jadwal: List<Jadwal>,
    @Expose
    @SerializedName("message")
    val message: String
)