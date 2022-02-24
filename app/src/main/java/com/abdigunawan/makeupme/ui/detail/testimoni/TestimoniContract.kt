package com.abdigunawan.makeupme.ui.detail.testimoni

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.response.home.testimoni.HomeTestimoniResponse


interface TestimoniContract {

    interface View: BaseView {
        fun onTestimoniSuccess(homeTestimoniResponse: HomeTestimoniResponse)
        fun onTestimoniFailed(message:String)
    }

    interface Presenter : TestimoniContract, BasePresenter {
        fun getTestimoni(muaId : String)
    }
}