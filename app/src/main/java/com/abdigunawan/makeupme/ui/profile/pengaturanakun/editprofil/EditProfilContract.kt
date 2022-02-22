package com.abdigunawan.makeupme.ui.profile.pengaturanakun.editprofil

import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView
import com.abdigunawan.makeupme.model.request.EditProfilRequest
import com.abdigunawan.makeupme.model.response.editprofil.EditProfilResponse
import com.abdigunawan.makeupme.model.response.editprofil.Ubahprofile


interface EditProfilContract {

    interface View: BaseView {
        fun onEditProfilSuccess(editProfilResponse: Ubahprofile)
        fun onEditProfilFailed(message:String)
    }

    interface Presenter : EditProfilContract, BasePresenter {
        fun editProfil(editProfilRequest: EditProfilRequest , view:android.view.View)
    }
}