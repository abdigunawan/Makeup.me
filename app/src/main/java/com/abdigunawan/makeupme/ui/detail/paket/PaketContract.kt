package com.abdigunawan.makeupme.ui.detail.paket

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.response.home.HomeGetMuaResponse
import com.abdigunawan.makeupme.model.response.home.paket.MuaPaketResponse


interface PaketContract {

    interface View: BaseView {
        fun onPaketSuccess(muaPaketResponse: MuaPaketResponse)
        fun onPaketFailed(message:String)
    }

    interface Presenter : PaketContract, BasePresenter {
        fun getPaket(muaId : String)
    }
}