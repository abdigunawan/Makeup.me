package com.abdigunawan.makeupme.ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.ui.auth.AuthActivity
import kotlinx.android.synthetic.main.fragment_sign_up_address.*

class SignUpAddressFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up_address, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnSignupNow.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_signup_success, null)

            (activity as AuthActivity).toolbarSignupSuccess()
        }
    }
}