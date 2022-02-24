package com.abdigunawan.makeupme.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.abdigunawan.makeupme.R
import kotlinx.android.synthetic.main.fragment_orders.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_orders, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initView()

        val sectionsPagerAdapter = SectionsPagerAdapter(childFragmentManager)
        viewPager.adapter = sectionsPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun initView() {
        include_toolbar.toolbar.title = "Riwayat Booking"
        include_toolbar.toolbar.subtitle = "Semua Riwayat Booking Kamu"
    }

}