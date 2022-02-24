package com.abdigunawan.makeupme.ui.order.dibatalkan

import com.abdigunawan.makeupme.network.HttpClient
import com.abdigunawan.makeupme.utils.Helpers.getErrorBodyMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BatalPresenter (private val view:BatalContract.View) : BatalContract.Presenter {

    private val mCompositeDisposable : CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }


    override fun getPending() {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.getRiwayatOrder()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dismissLoading()

                    if (it.message.equals("Data Berhasil ditampilkan")) {
                        it.transaksiuser.let { data -> view.onPendingSuccess(it) }
                    } else {
                        view.onPendingFailed(it.message)
                    }

                },
                {
                    view.dismissLoading()
                    view.onPendingFailed(it.getErrorBodyMessage())
                })
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {}

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }
}