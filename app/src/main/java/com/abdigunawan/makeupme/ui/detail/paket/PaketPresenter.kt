package com.abdigunawan.makeupme.ui.detail.paket

import com.abdigunawan.makeupme.utils.Helpers.getErrorBodyMessage
import com.abdigunawan.makeupme.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PaketPresenter (private val view: PaketContract.View) : PaketContract.Presenter {


    private var mCompositeDisposable : CompositeDisposable?
    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun getPaket(muaId: String) {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.getpaketmua(muaId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dismissLoading()

                    if (it.message.equals("Data berhasil ditampilkan")) {
                        it.paket.let { data -> view.onPaketSuccess(it) }
                    } else {
                        view.onPaketFailed(it.message)
                    }

                },
                {
                    view.dismissLoading()
                    view.onPaketFailed(it.getErrorBodyMessage())
                })
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }

}