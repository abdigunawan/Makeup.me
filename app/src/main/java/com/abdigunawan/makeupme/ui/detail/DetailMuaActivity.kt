package com.abdigunawan.makeupme.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.abdigunawan.makeupme.BuildConfig
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.home.Kota
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_mua.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class DetailMuaActivity : AppCompatActivity() {

    private val detailmua by lazy { intent.getSerializableExtra("detailmua") as Kota }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mua)

        initView()
        initListener()

        val sectionPagerAdapter = SectionPagerAdapter (getSupportFragmentManager())
        viewPager.adapter = sectionPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }


    private fun initView() {
        val profilMua = BuildConfig.BASE_URL+"assets/img/mua/" + detailmua.gambar
        Glide.with(this)
            .load(profilMua)
            .apply(RequestOptions.centerCropTransform())
            .into(ivProfilMua)
        tvNamaMua.text = detailmua.name
        tvAlamatMua.setText(detailmua.alamat + ", " + detailmua.noRumah)
        tvTeleponMua.text = detailmua.noHp
    }

    private fun initListener() {
        btnChat.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/62" + detailmua.noHp + "/?text=Halo%20Kak%20" + detailmua.name))
            startActivity(intent)
        }
    }

}