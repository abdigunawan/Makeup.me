package com.abdigunawan.makeupme.ui.auth.signin

import android.widget.Toast
import com.abdigunawan.makeupme.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SignInPresenter (private val view:SignInContract.View) : SignInContract.Presenter {

    private var mCompositeDisposable : CompositeDisposable?
    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }

    override fun submitLogin(email: String, password: String) {
        view.showLoading()
        val disposable = HttpClient.getInstance().getApi()!!.login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dismissLoading()

                    if (it.message == "Berhasil Login") {
                        if (it.x0.user.roles == "USER") {
                            it.x0.let { x0 -> view.onLoginSuccess(x0) }
                        } else if (it.x0.user.roles == "MUA") {
                            view.onLoginFailed("Anda Terdaftar Sebagai MUA \nSilahkan Login Di Aplikasi Mua Partner")
                        }
                    } else {
                        view.onLoginFailed(it.message)
                    }
                },{
                    view.dismissLoading()
                    view.onLoginFailed(it.message.toString())
                }
            )
        mCompositeDisposable!!.add(disposable)
    }

}