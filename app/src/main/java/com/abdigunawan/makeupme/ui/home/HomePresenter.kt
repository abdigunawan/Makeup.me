package com.abdigunawan.makeupme.ui.home

import com.abdigunawan.makeupme.utils.Helpers.getErrorBodyMessage
import com.abdigunawan.makeupme.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter (private val view: HomeContract.View) : HomeContract.Presenter {


    private var mCompositeDisposable : CompositeDisposable?
    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun getHome() {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.getproduk()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dismissLoading()

                    if (it.message.equals("Data berhasil ditampilkan")) {
                        it.kota.let { data -> view.onHomeSuccess(it) }
                    } else {
                        view.onHomeFailed(it.message)
                    }

                },
                {
                    view.dismissLoading()
                    view.onHomeFailed(it.getErrorBodyMessage())
                })
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }

}