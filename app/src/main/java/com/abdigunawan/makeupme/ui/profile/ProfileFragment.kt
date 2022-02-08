package com.abdigunawan.makeupme.ui.profile

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.abdigunawan.makeupme.BuildConfig
import com.abdigunawan.makeupme.Makeupme
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.login.User
import com.abdigunawan.makeupme.ui.auth.AuthActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(),LogoutContract.View {

    lateinit var presenter : LogoutPresenter
    var progressDialog: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = LogoutPresenter(this)
        initUser()
        initListener()
        initView()

    }

    private fun initView() {
        progressDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)

        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    private fun initUser() {
        var user = Makeupme.getApp().getUser()
        var userResponse = Gson().fromJson(user, User::class.java)

        if (!userResponse.gambar.isNullOrEmpty()) {
            val profilMua = BuildConfig.BASE_URL+"assets/img/user/" + userResponse.gambar
            Glide.with(requireActivity())
                .load(profilMua)
                .apply(RequestOptions.circleCropTransform())
                .into(ivUserLogin)
        }

        tvUserLogin.setText(userResponse.name)
        tvEmailUserLogin.setText(userResponse.email)
    }

    private fun initListener() {
        layoutTentangMakeupme.setOnClickListener {
            val about = Intent(activity, AboutActivity::class.java)
            startActivity(about)
        }

        btnLogout.setOnClickListener {
            SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Logout")
                .setContentText("Kamu Yakin Ingin Logout?")
                .setCancelButton("Batal", SweetAlertDialog.OnSweetClickListener {
                    it.dismissWithAnimation()
                })
                .setConfirmButton("Yakin", SweetAlertDialog.OnSweetClickListener {
                    presenter.Logout()
                })
                .show()
        }
    }

    override fun onLogoutSuccess(message: String) {
        Makeupme.getApp().setToken(null)
        Makeupme.getApp().setUser(null)

        val login = Intent(activity, AuthActivity::class.java)
        startActivity(login)
        activity?.finish()
    }

    override fun onLogoutFailed(message: String) {
        SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("Gagal Log Out")
            .setContentText(message)
            .show()
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()
    }
}