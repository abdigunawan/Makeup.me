package com.abdigunawan.makeupme.ui.home

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.response.home.HomeGetMuaResponse


interface HomeContract {

    interface View: BaseView {
        fun onHomeSuccess(homeGetMuaResponse: HomeGetMuaResponse)
        fun onHomeFailed(message:String)
    }

    interface Presenter : HomeContract, BasePresenter {
        fun getHome()
    }
}