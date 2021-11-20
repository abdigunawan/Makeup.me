package com.abdigunawan.makeupme.model.dummy

class MuaTestimoniModel(pelanggan:String, src:String, komentar:String, tanggal:String, rating:Float) {

    var pelanggan = ""
    var src = ""
    var komentar = ""
    var tanggal = ""
    var rating = 0f

    init {
        this.pelanggan = pelanggan
        this.src = src
        this.komentar = komentar
        this.tanggal = tanggal
        this.rating = rating

    }

}