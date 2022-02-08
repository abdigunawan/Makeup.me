package com.abdigunawan.makeupme.ui.detail

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.abdigunawan.makeupme.ui.detail.jadwal.JadwalMuaFragment
import com.abdigunawan.makeupme.ui.detail.paket.PaketMuaFragment
import com.abdigunawan.makeupme.ui.detail.testimoni.TestimoniMuaFragment
import com.abdigunawan.makeupme.ui.profile.akun.ProfileAccountFragment
import com.abdigunawan.makeupme.ui.profile.makeupme.ProfileMakeupMeFragment

class SectionPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> {
                "Paket"
            }
            1 -> {
                "Jadwal"
            }
            2 -> {
                "Testimoni"
            }
            else -> {
                ""
            }

        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment
        return when(position) {
            0 -> {
                fragment = PaketMuaFragment()
                return fragment
            }
            1 -> {
                fragment = JadwalMuaFragment()
                return fragment
            }
            2 -> {
                fragment = TestimoniMuaFragment()
                return fragment
            }
            else -> {
                fragment = PaketMuaFragment()
                return fragment
            }
        }
    }
}