package com.abdigunawan.makeupme.ui.order.selesai

import com.abdigunawan.makeupme.network.HttpClient
import com.abdigunawan.makeupme.utils.Helpers.getErrorBodyMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SelesaiPresenter (private val view:SelesaiContract.View) : SelesaiContract.Presenter {

    private val mCompositeDisposable : CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }


    override fun getSelesai() {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.getSelesai()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dismissLoading()

                    if (it.message.equals("Data Berhasil ditampilkan")) {
                        it.transaksiuser.let { data -> view.onSelesaiSuccess(it) }
                    } else {
                        view.onSelesaiFailed(it.message)
                    }

                },
                {
                    view.dismissLoading()
                    view.onSelesaiFailed(it.getErrorBodyMessage())
                })
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {}

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }
}