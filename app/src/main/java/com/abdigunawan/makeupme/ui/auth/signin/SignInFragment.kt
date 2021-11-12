package com.abdigunawan.makeupme.ui.auth.signin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

}