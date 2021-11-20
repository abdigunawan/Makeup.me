package com.abdigunawan.makeupme.ui.profile.makeupme

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.dummy.ProfileMenuModel
import com.abdigunawan.makeupme.ui.detail.DetailMuaActivity
import com.abdigunawan.makeupme.ui.profile.ProfileMenuAdapter
import kotlinx.android.synthetic.main.fragment_profile_account.*

class ProfileMakeupMeFragment : Fragment(),ProfileMenuAdapter.ItemAdapterCallback {

    private var menuArrayList: ArrayList<ProfileMenuModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_account, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()

        var adapter = ProfileMenuAdapter(menuArrayList, this)
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter
    }

    fun initDataDummy() {
        menuArrayList = ArrayList()
        menuArrayList.add(ProfileMenuModel("Tentang Makeup.me"))
        menuArrayList.add(ProfileMenuModel("Beri Rating Aplikasi"))
        menuArrayList.add(ProfileMenuModel("Pusat Bantuan"))

    }

    override fun onClick(v: View, data: ProfileMenuModel) {
        if (data.title == "Tentang Makeup.me") {
            val about = Intent(activity, AboutActivity::class.java)
            startActivity(about)
        }

        Toast.makeText(context, "Ini menu yang kamu klik "+ data.title, Toast.LENGTH_SHORT).show()
    }

}