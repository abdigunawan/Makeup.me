package com.abdigunawan.makeupme.ui.order.beritestimoni

import android.net.Uri
import com.abdigunawan.makeupme.network.HttpClient
import com.abdigunawan.makeupme.utils.Helpers.getErrorBodyMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class BeriTestimoniPresenter(private val view: BeriTestimoniContract.View) : BeriTestimoniContract.Presenter {


    private var mCompositeDisposable : CompositeDisposable?
    init {
        this.mCompositeDisposable = CompositeDisposable()
    }


    override fun addTestimoni(transaksiId: String, catatan: String, gambar: Uri) {
        view.showLoading()

        var txtCatatan = RequestBody.create(MediaType.parse("text/plain"),catatan)
        var fotoprodukFile = File(gambar.path)
        var fotoprodukRequestBody = RequestBody.create(MediaType.parse("multipart/form-data"),fotoprodukFile)
        val fotoprodukParms = MultipartBody.Part.createFormData("gambar",fotoprodukFile.name, fotoprodukRequestBody)

        val disposable = HttpClient.getInstance().getApi()!!.testimoni(
            transaksiId,
            fotoprodukParms,
            txtCatatan
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.dismissLoading()

                if (it.message.equals("Berhasil Tambah Testimoni")) {
                    view.onTestimoniSuccess(it.message)
                }else {
                    view.onTestimoniFailed(it.message)
                }
            },{
                view.dismissLoading()
                view.onTestimoniFailed(it.getErrorBodyMessage())
            })
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }

}