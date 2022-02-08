package com.abdigunawan.makeupme.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abdigunawan.makeupme.BuildConfig
import com.abdigunawan.makeupme.Makeupme
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.login.User
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
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

        initUser()
        initListener()


//        val sectionPagerAdapter = SectionPagerAdapter (
//            childFragmentManager
//        )
//        viewPager.adapter = sectionPagerAdapter
//        tabLayout.setupWithViewPager(viewPager)

    }

    private fun initUser() {
        var user = Makeupme.getApp().getUser()
        var userResponse = Gson().fromJson(user, User::class.java)

        if (!userResponse.gambar.isNullOrEmpty()) {
            val profilMua = BuildConfig.BASE_URL+"assets/img/user/" + userResponse.gambar
            Glide.with(requireActivity())
                .load(profilMua)
                .apply(RequestOptions.circleCropTransform())
                .into(ivUserLogin)
        }

        tvUserLogin.setText(userResponse.name)
        tvEmailUserLogin.setText(userResponse.email)
    }

    private fun initListener() {
        layoutTentangMakeupme.setOnClickListener {
            val about = Intent(activity, AboutActivity::class.java)
            startActivity(about)
        }
    }
}