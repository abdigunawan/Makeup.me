package com.abdigunawan.makeupme.ui.auth.signup

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.abdigunawan.makeupme.R
import androidx.navigation.Navigation
import com.abdigunawan.makeupme.model.request.RegisterRequest
import com.abdigunawan.makeupme.ui.auth.AuthActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment() {


    var gambar: Uri?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        initListener()

    }

    private fun initListener() {

        btnContinue.setOnClickListener {

            var namalengkap = etSignupNama.text.toString()
            var email = etSignupEmail.text.toString()
            var password = etSignupPassword.text.toString()

            if (namalengkap.isNullOrEmpty()) {
                etSignupNama.error = "Masukkan Nama Dulu"
                etSignupNama.requestFocus()
            } else if (email.isNullOrEmpty()) {
                etSignupEmail.error = "Masukkan Email Dulu"
                etSignupEmail.requestFocus()
            } else if (password.isNullOrEmpty()) {
                etSignupPassword.error = "Masukkan Password Dulu"
                etSignupPassword.requestFocus()
            }
            else {
                var data = RegisterRequest(
                    namalengkap,
                    email,
                    password,
                    "",
                    "",
                    "",
                    "",
                    gambar,
                    ""
                )

                var bundle = Bundle()
                bundle.putParcelable("data", data)

                Navigation.findNavController(it)
                    .navigate(R.id.action_signup_address, bundle)

                (activity as AuthActivity).toolbarSignupAddress()
            }
        }

        ivSignupFoto.setOnClickListener {
            ImagePicker.with(this)
                .cropSquare()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            gambar = data?.data

            Glide.with(this)
                .load(gambar)
                .apply(RequestOptions.circleCropTransform())
                .into(ivSignupFoto)

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(context, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Pilih Foto Dibatallan", Toast.LENGTH_SHORT).show()
        }
    }
}