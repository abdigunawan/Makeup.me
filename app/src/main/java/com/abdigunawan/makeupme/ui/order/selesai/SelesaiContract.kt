package com.abdigunawan.makeupme.ui.order.selesai

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.response.orderkonfirmasi.OrderKonfirmasiTransaksiResponse
import com.abdigunawan.makeupme.model.response.orderselesai.OrderSelesaiTransaksiResponse


interface SelesaiContract {
    interface View : BaseView {
        fun onSelesaiSuccess(orderSelesaiTransaksiResponse: OrderSelesaiTransaksiResponse)
        fun onSelesaiFailed(message: String)
    }

    interface Presenter : SelesaiContract, BasePresenter {
        fun getSelesai()
    }
}