package com.abdigunawan.makeupme.ui.detail.paket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.ui.detail.DetailMuaActivity
import kotlinx.android.synthetic.main.fragment_customize_order.*

class CustomizeOrderFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customize_order, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnNext.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_fragmentCustomizeOrder_to_fragmentPembayaran, null)

            (activity as DetailMuaActivity).toolbarPayment()
        }
    }
}