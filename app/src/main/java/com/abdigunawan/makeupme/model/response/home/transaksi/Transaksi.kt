package com.abdigunawan.makeupme.model.response.home.transaksi


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Transaksi(
    @Expose
    @SerializedName("catatan")
    val catatan: String,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("id_paket")
    val idPaket: Int,
    @Expose
    @SerializedName("id_user")
    val idUser: Int,
    @Expose
    @SerializedName("id_tukang")
    val idTukang: Int,
    @Expose
    @SerializedName("jam_acara")
    val jamAcara: String,
    @Expose
    @SerializedName("jumlah")
    val jumlah: String,
    @Expose
    @SerializedName("tanggal_acara")
    val tanggalAcara: String,
    @Expose
    @SerializedName("tanggal_transaksi")
    val tanggalTransaksi: String,
    @Expose
    @SerializedName("total_harga")
    val totalHarga: Int
)