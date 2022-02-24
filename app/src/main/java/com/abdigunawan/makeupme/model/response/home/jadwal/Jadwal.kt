package com.abdigunawan.makeupme.model.response.home.jadwal


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Jadwal(
    @SerializedName("catatan")
    val catatan: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("id_paket")
    val idPaket: Int,
    @SerializedName("id_tukang")
    val idTukang: Int,
    @SerializedName("id_user")
    val idUser: Int,
    @SerializedName("jam_acara")
    val jamAcara: String,
    @SerializedName("jumlah")
    val jumlah: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("tanggal_acara")
    val tanggalAcara: String,
    @Expose
    @SerializedName("tanggal_transaksi")
    val tanggalTransaksi: String,
    @SerializedName("total_harga")
    val totalHarga: String,
    @Expose
    @SerializedName("transaksiuser")
    val transaksiuser: Transaksiuser,
    @Expose
    @SerializedName("user")
    val user: User
)