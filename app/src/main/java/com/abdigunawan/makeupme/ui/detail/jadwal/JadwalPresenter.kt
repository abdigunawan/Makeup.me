package com.abdigunawan.makeupme.ui.detail.jadwal

import com.abdigunawan.makeupme.network.HttpClient
import com.abdigunawan.makeupme.utils.Helpers.getErrorBodyMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class JadwalPresenter (private val view: JadwalContract.View) : JadwalContract.Presenter {


    private var mCompositeDisposable : CompositeDisposable?
    init {
        this.mCompositeDisposable = CompositeDisposable()
    }


    override fun getJadwal(muaId: String) {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.getJadwal(muaId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dismissLoading()

                    if (it.message.equals("Data Berhasil ditampilkan")) {
                        it.jadwal.let { data -> view.onJadwalSuccess(it) }
                    } else {
                        view.onJadwalFailed(it.message)
                    }

                },
                {
                    view.dismissLoading()
                    view.onJadwalFailed(it.getErrorBodyMessage())
                })
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }

}