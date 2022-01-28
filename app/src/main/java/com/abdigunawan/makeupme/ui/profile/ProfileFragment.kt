package com.abdigunawan.makeupme.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abdigunawan.makeupme.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        layoutTentangMakeupme.setOnClickListener {
            val about = Intent(activity, AboutActivity::class.java)
            startActivity(about)
        }

//        val sectionPagerAdapter = SectionPagerAdapter (
//            childFragmentManager
//        )
//        viewPager.adapter = sectionPagerAdapter
//        tabLayout.setupWithViewPager(viewPager)

    }
}