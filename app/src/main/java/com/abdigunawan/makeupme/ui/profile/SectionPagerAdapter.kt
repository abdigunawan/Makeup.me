package com.abdigunawan.makeupme.ui.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.abdigunawan.makeupme.ui.profile.akun.ProfileAccountFragment
import com.abdigunawan.makeupme.ui.profile.makeupme.ProfileMakeupMeFragment

class SectionPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> {
                "Akun"
            }
            1 -> {
                "Makeup.me"
            }
            else -> {
                ""
            }

        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment
        return when(position) {
            0 -> {
                fragment = ProfileAccountFragment()
                return fragment
            }
            1 -> {
                fragment = ProfileMakeupMeFragment()
                return fragment
            }
            else -> {
                fragment = ProfileAccountFragment()
                return fragment
            }
        }
    }
}