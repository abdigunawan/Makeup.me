package com.abdigunawan.makeupme.ui.order.beritestimoni

import android.net.Uri
import com.abdigunawan.makeupme.base.BasePresenter
import com.abdigunawan.makeupme.base.BaseView

interface BeriTestimoniContract {

    interface View: BaseView {
        fun onTestimoniSuccess(message:String)
        fun onTestimoniFailed(message:String)
    }

    interface Presenter : BeriTestimoniContract, BasePresenter {
        fun addTestimoni(transaksiId: String, catatan : String, gambar: Uri)
    }
}