package com.abdigunawan.makeupme.ui.profile.makeupme.saran

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView


interface BeriMasukanContract {

    interface View: BaseView {
        fun onBeriMasukanSuccess(message: String)
        fun onBeriMasukanFailed(message:String)
    }

    interface Presenter : BeriMasukanContract, BasePresenter {
        fun submitSaran(id_user: String?, saran: String)
    }
}