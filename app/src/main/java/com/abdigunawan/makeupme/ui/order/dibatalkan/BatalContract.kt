package com.abdigunawan.makeupme.ui.order.dibatalkan

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.response.order.RiwayatTransaksiResponse


interface BatalContract {
    interface View : BaseView {
        fun onPendingSuccess(riwayatTransaksiResponse: RiwayatTransaksiResponse)
        fun onPendingFailed(message: String)
    }

    interface Presenter : BatalContract, BasePresenter {
        fun getPending()
    }
}