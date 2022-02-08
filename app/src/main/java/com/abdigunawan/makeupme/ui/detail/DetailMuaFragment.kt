package com.abdigunawan.makeupme.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abdigunawan.makeupme.R
import kotlinx.android.synthetic.main.fragment_detail_mua.*
import kotlinx.android.synthetic.main.item_paket_horizontal.*

class DetailMuaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_mua, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val sectionPagerAdapter = SectionPagerAdapter (
            childFragmentManager
        )
        viewPager.adapter = sectionPagerAdapter
        tabLayout.setupWithViewPager(viewPager)


        (activity as DetailMuaActivity).toolbarDetailMua()

    }



}