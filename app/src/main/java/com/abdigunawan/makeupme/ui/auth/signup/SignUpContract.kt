package com.abdigunawan.makeupme.ui.auth.signup

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.request.RegisterRequest
import com.abdigunawan.makeupme.model.response.login.X0


interface SignUpContract {

    interface View: BaseView {
        fun onRegisterSuccess(loginResponse: X0, view: android.view.View)
        fun onRegisterFailed(message:String)
    }

    interface Presenter : SignUpContract, BasePresenter {
        fun submitRegister(registerRequest: RegisterRequest, view:android.view.View)
    }
}