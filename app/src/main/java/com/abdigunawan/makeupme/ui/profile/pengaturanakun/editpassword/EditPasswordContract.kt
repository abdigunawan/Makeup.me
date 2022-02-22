package com.abdigunawan.makeupme.ui.profile.pengaturanakun.editpassword

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView


interface EditPasswordContract {

    interface View: BaseView {
        fun oneditPasswordSuccess(message: String)
        fun oneditPasswordFailed(message:String)
    }

    interface Presenter : EditPasswordContract, BasePresenter {
        fun submitPassword(passwordlama:String, passwordbaru:String, passwordkonfirmasi: String)
    }
}