package com.abdigunawan.makeupme.ui.order.pending

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.response.order.RiwayatTransaksiResponse


interface PendingContract {
    interface View : BaseView {
        fun onTransactionSuccess(riwayatTransaksiResponse: RiwayatTransaksiResponse)
        fun onTransactionFailed(message: String)
    }

    interface Presenter : PendingContract, BasePresenter {
        fun getTransaction()
    }
}