package com.abdigunawan.makeupme.ui.auth.signin

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.response.login.X0


interface SignInContract {

    interface View: BaseView {
        fun onLoginSuccess(loginResponse: X0?)
        fun onLoginFailed(message:String)
    }

    interface Presenter : SignInContract, BasePresenter {
        fun submitLogin(email:String, password:String)
    }
}