package com.abdigunawan.makeupme.ui.detail.paket.order

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.response.home.paket.MuaPaketResponse


interface PaymentContract {

    interface View: BaseView {
        fun onPaymentSuccess(message: String)
        fun onPaymentFailed(message:String)
    }

    interface Presenter : PaymentContract, BasePresenter {
        fun addTransaksi(paketId : String ,jumlah : String, tanggalacara : String ,jamacara : String,catatan : String )
    }
}