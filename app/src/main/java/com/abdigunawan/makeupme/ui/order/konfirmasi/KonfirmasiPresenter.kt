package com.abdigunawan.makeupme.ui.order.konfirmasi

import com.abdigunawan.makeupme.network.HttpClient
import com.abdigunawan.makeupme.utils.Helpers.getErrorBodyMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class KonfirmasiPresenter (private val view:KonfirmasiContract.View) : KonfirmasiContract.Presenter {

    private val mCompositeDisposable : CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }


    override fun getKonfirmasi() {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.getKonfirmasi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dismissLoading()

                    if (it.message.equals("Data Berhasil ditampilkan")) {
                        it.transaksiuser.let { data -> view.onKonfirmasiSuccess(it) }
                    } else {
                        view.onKonfirmasiFailed(it.message)
                    }

                },
                {
                    view.dismissLoading()
                    view.onKonfirmasiFailed(it.getErrorBodyMessage())
                })
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {}

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }
}