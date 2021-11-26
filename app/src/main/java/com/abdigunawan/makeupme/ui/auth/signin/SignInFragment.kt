package com.abdigunawan.makeupme.ui.auth.signin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.ui.MainActivity
import com.abdigunawan.makeupme.ui.auth.AuthActivity
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnSignup.setOnClickListener {
            val signup = Intent(activity, AuthActivity::class.java)
            signup.putExtra("page_request", 2)
            startActivity(signup)
        }

        btnSignin.setOnClickListener {
            val home = Intent(activity, MainActivity::class.java)
            startActivity(home)
            activity?.finish()
        }

        tvLupaPassword.setOnClickListener {
            Toast.makeText(context, "Membuka WhatsApp ", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6282293204972/?text=Halo%20Min!%0ASaya%20mempunyai%20masalah%20terkait%20akun%20makeup.me%20saya,%20apakah%20bisa%20dibantu?"))
            startActivity(intent)
        }
    }

}