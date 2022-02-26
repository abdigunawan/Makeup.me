package com.abdigunawan.makeupme.ui.order

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.abdigunawan.makeupme.ui.order.dibatalkan.BatalFragment
import com.abdigunawan.makeupme.ui.order.konfirmasi.KonfirmasiFragment
import com.abdigunawan.makeupme.ui.order.pending.PendingFragment
import com.abdigunawan.makeupme.ui.order.selesai.SelesaiFragment

class SectionsPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(
        fm
    ) {

    override fun getItem(position: Int): Fragment {

        var fragment : Fragment
        return when (position) {
            0 -> {
                    fragment = PendingFragment()
                    return fragment
            }
            1 -> {
                    fragment = KonfirmasiFragment()
                    return fragment
                }
            2 -> {
                fragment = SelesaiFragment()
                return fragment
            }
            3 -> {
                fragment = BatalFragment()
                return fragment
            }

            else -> {
                fragment = PendingFragment()
                return fragment
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Pending"
            1 -> "Konfirmasi"
            2 -> "Selesai"
            3 -> "Batal"
            else -> null
        }
    }

    override fun getCount(): Int {
        return 4
    }

}