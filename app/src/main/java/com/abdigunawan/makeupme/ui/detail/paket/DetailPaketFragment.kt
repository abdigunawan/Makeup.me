package com.abdigunawan.makeupme.ui.detail.paket

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.ui.detail.DetailMuaActivity
import kotlinx.android.synthetic.main.fragment_detail_paket.*

class DetailPaketFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_paket, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnOrderNow.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_fragmentDetailPaket_to_fragmentCustomizeOrder, null)

            (activity as DetailMuaActivity).toolbarPayment()
        }

    }
}