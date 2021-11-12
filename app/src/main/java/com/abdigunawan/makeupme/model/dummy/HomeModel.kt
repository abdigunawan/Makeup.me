package com.abdigunawan.foodmarketkotlin.model.dummy

class HomeModel(title:String, alamat:String, src:String, rating:Float) {

    var title = ""
    var alamat = ""
    var src = ""
    var rating = 0f

    init {
        this.title = title
        this.alamat = alamat
        this.src = src
        this.rating = rating
    }

}