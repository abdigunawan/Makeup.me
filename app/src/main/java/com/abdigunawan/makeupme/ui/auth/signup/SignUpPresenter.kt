package com.abdigunawan.makeupme.ui.auth.signup

import android.view.View
import com.abdigunawan.makeupme.model.request.RegisterRequest
import com.abdigunawan.makeupme.utils.Helpers.getErrorBodyMessage
import com.abdigunawan.muapartner.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class SignUpPresenter (private val view: SignUpContract.View) : SignUpContract.Presenter {


    private var mCompositeDisposable : CompositeDisposable?
    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun submitRegister(registerRequest: RegisterRequest, viewParams: View) {
        view.showLoading()

        var name = RequestBody.create(MediaType.parse("text/plain"),registerRequest.name)
        var email = RequestBody.create(MediaType.parse("text/plain"),registerRequest.email)
        var password = RequestBody.create(MediaType.parse("text/plain"),registerRequest.password)
        var nohp = RequestBody.create(MediaType.parse("text/plain"),registerRequest.no_hp)
        var alamat = RequestBody.create(MediaType.parse("text/plain"),registerRequest.alamat)
        var norumah = RequestBody.create(MediaType.parse("text/plain"),registerRequest.no_rumah)
        var kota = RequestBody.create(MediaType.parse("text/plain"),registerRequest.kota)
        var role = RequestBody.create(MediaType.parse("text/plain"),registerRequest.roles)


        if (registerRequest.gambar == null) {
            val disposable = HttpClient.getInstance().getApi()!!.register(
                name,
                email,
                password,
                nohp,
                alamat,
                norumah,
                kota,
                null,
                role

            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        view.dismissLoading()

                        if (it.message.equals("Berhasil Register")) {
                            it.x0.let { data -> view.onRegisterSuccess(data , viewParams) }
                        } else {
                            view.onRegisterFailed("Masukkan data dengan lengkap\n atau email telah digunakan")
                        }
                    },
                    {
                        view.dismissLoading()
                        view.onRegisterFailed(it.getErrorBodyMessage())
                    })
            mCompositeDisposable!!.add(disposable)

        } else {
            var profileImageFile = File(registerRequest.gambar?.path)
            var profileImageRequestBody = RequestBody.create(MediaType.parse("multipart/form-data"),profileImageFile)
            val profileImageParms = MultipartBody.Part.createFormData("gambar",profileImageFile.name, profileImageRequestBody)

            val disposable = HttpClient.getInstance().getApi()!!.register(
                name,
                email,
                password,
                nohp,
                alamat,
                norumah,
                kota,
                profileImageParms,
                role

            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        view.dismissLoading()

                        if (it.message.equals("Berhasil Register")) {
                            it.x0.let { data -> view.onRegisterSuccess(data , viewParams) }
                        } else {
                            view.onRegisterFailed("Masukkan data dengan lengkap\n atau email telah digunakan")
                        }
                    },
                    {
                        view.dismissLoading()
                        view.onRegisterFailed(it.getErrorBodyMessage())
                    })
            mCompositeDisposable!!.add(disposable)
        }

    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }

}