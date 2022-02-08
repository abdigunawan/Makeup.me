package com.abdigunawan.makeupme.ui.auth.signup

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.Navigation
import cn.pedant.SweetAlert.SweetAlertDialog
import com.abdigunawan.makeupme.Makeupme
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.request.RegisterRequest
import com.abdigunawan.makeupme.model.response.login.X0
import com.abdigunawan.makeupme.ui.auth.AuthActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_sign_up_address.*

class SignUpAddressFragment : Fragment(),SignUpContract.View {

    lateinit var kota : Spinner
    lateinit var data: RegisterRequest
    lateinit var presenter : SignUpPresenter
    var progressDialog: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up_address, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = SignUpPresenter(this)
        data = arguments?.getParcelable<RegisterRequest>("data")!!

        initView()
        initKota()
        initListener()

    }

    private fun initKota() {
        kota = activity?.findViewById(R.id.spinnerKota) as Spinner
        val isikota = arrayOf("Makassar","Maros","Gowa","Bone")
        kota.adapter = context?.let { ArrayAdapter<String>(it,R.layout.layout_spinner, isikota) }
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

    private fun initListener() {

        btnSignupNow.setOnClickListener {

            var nohp = etSignUpNohp.text.toString()
            var alamat = etSignupAlamat.text.toString()
            var norumah = etSignupNoRumah.text.toString()
            var kota = spinnerKota.selectedItem.toString()
            val role = ""

            data.let {
                it.no_hp = nohp
                it.alamat = alamat
                it.no_rumah = norumah
                it.kota = kota
                it.roles = role
            }

            if (nohp.isNullOrEmpty()) {
                etSignUpNohp.error = "Masukkan Nomor HP Dulu"
                etSignUpNohp.requestFocus()
            } else if (alamat.isNullOrEmpty()) {
                etSignupAlamat.error = "Masukkan Alamatmu Dulu"
                etSignupAlamat.requestFocus()
            } else if (norumah.isNullOrEmpty()) {
                etSignupNoRumah.error = "Masukkan Nomor Rumahmu Dulu dong"
                etSignupNoRumah.requestFocus()
            } else if (kota.isNullOrEmpty()) {
                Toast.makeText(context, "Pilih Kota Dulu", Toast.LENGTH_SHORT).show()
                spinnerKota.requestFocus()
            } else {
                presenter.submitRegister(data, it)
            }

        }
    }

    override fun onRegisterSuccess(loginResponse: X0, view: View) {
        Makeupme.getApp().setToken(loginResponse.token)

        val gson = Gson()
        val json = gson.toJson(loginResponse.user)
        Makeupme.getApp().setUser(json)

        Navigation.findNavController(view)
            .navigate(R.id.action_signup_success, null)
        (activity as AuthActivity).toolbarSignupSuccess()

    }

    override fun onRegisterFailed(message: String) {
        SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("Gagal Registrasi")
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