package com.abdigunawan.makeupme.ui.detail.paket.order

import com.abdigunawan.makeupme.utils.Helpers.getErrorBodyMessage
import com.abdigunawan.makeupme.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PaymentPresenter (private val view: PaymentContract.View) : PaymentContract.Presenter {


    private var mCompositeDisposable : CompositeDisposable?
    init {
        this.mCompositeDisposable = CompositeDisposable()
    }



    override fun addTransaksi(
        paketId: String,
        jumlah: String,
        tanggalacara: String,
        jamacara: String,
        catatan: String
    ) {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.transaksipaket(
            paketId,
            jumlah,
            tanggalacara,
            jamacara,
            catatan
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dismissLoading()

                    if (it.message.equals("Berhasil Transaksi")) {
                        view.onPaymentSuccess(it.message)
                    } else {
                        view.onPaymentFailed(it.message)
                    }

                },
                {
                    view.dismissLoading()
                    view.onPaymentFailed(it.getErrorBodyMessage())
                })
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }

}