package com.abdigunawan.makeupme.ui.detail.paket

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.ui.MainActivity
import com.abdigunawan.makeupme.ui.detail.DetailMuaActivity
import kotlinx.android.synthetic.main.fragment_detail_mua.*
import kotlinx.android.synthetic.main.fragment_detail_paket.*
import kotlinx.android.synthetic.main.fragment_sign_up_address.*

class DetailPaketFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_paket, container, false)
    }
}