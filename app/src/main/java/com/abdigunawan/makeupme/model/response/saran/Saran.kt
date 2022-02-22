package com.abdigunawan.makeupme.model.response.saran


import com.google.gson.annotations.SerializedName

data class Saran(
    @SerializedName("id")
    val id: Int,
    @SerializedName("id_user")
    val idUser: Int,
    @SerializedName("saran")
    val saran: String
)