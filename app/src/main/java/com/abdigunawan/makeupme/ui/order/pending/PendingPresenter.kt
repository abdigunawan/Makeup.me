package com.abdigunawan.makeupme.ui.order.pending

import com.abdigunawan.makeupme.network.HttpClient
import com.abdigunawan.makeupme.utils.Helpers.getErrorBodyMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PendingPresenter (private val view:PendingContract.View) : PendingContract.Presenter {

    private val mCompositeDisposable : CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun getTransaction() {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.getRiwayatOrder()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dismissLoading()

                    if (it.message.equals("Data Berhasil ditampilkan")) {
                        it.transaksiuser.let { data -> view.onTransactionSuccess(it) }
                    } else {
                        view.onTransactionFailed(it.message)
                    }

                },
                {
                    view.dismissLoading()
                    view.onTransactionFailed(it.getErrorBodyMessage())
                })
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {}

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }
}