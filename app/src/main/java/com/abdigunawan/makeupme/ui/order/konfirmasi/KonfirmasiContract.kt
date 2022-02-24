package com.abdigunawan.makeupme.ui.order.konfirmasi

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.response.orderkonfirmasi.OrderKonfirmasiTransaksiResponse


interface KonfirmasiContract {
    interface View : BaseView {
        fun onKonfirmasiSuccess(orderKonfirmasiTransaksiResponse: OrderKonfirmasiTransaksiResponse)
        fun onKonfirmasiFailed(message: String)
    }

    interface Presenter : KonfirmasiContract, BasePresenter {
        fun getKonfirmasi()
    }
}