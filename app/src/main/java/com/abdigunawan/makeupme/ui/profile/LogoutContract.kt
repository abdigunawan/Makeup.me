package com.abdigunawan.makeupme.ui.profile

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView


interface LogoutContract {

    interface View: BaseView {
        fun onLogoutSuccess(message:String)
        fun onLogoutFailed(message:String)
    }

    interface Presenter : LogoutContract, BasePresenter {
        fun Logout()
    }
}