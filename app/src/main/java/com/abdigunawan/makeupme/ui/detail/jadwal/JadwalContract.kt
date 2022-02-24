package com.abdigunawan.makeupme.ui.detail.jadwal

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.response.home.jadwal.HomeJadwalResponse
import com.abdigunawan.makeupme.model.response.home.testimoni.HomeTestimoniResponse


interface JadwalContract {

    interface View: BaseView {
        fun onJadwalSuccess(homeJadwalResponse: HomeJadwalResponse)
        fun onJadwalFailed(message:String)
    }

    interface Presenter : JadwalContract, BasePresenter {
        fun getJadwal(muaId : String)
    }
}