package com.abdigunawan.makeupme.ui.detail.paket.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdigunawan.makeupme.BuildConfig
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.home.paket.Paket
import com.abdigunawan.makeupme.ui.detail.paket.order.CustomizeOrderActivity
import com.abdigunawan.makeupme.utils.Helpers.formatPrice
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_paket.*

class DetailPaketActivity : AppCompatActivity() {

    private val detailpaket by lazy { intent.getSerializableExtra("detailpaket") as Paket }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_paket)
        initListener()
        initView()
    }

    private fun initListener() {

        btnOrderNow.setOnClickListener {
            val custom = Intent(this, CustomizeOrderActivity::class.java).putExtra("detailpaket", detailpaket)
            startActivity(custom)
        }

        ivBack.setOnClickListener {
            onBackPressed()
        }

    }

    private fun initView() {

        tvNamaPaket.text = detailpaket.namaPaket
        tvDesc.text = detailpaket.deskripsi
        tvTotal.formatPrice(detailpaket.harga.toString())
        tvIngredients.text = detailpaket.produk
        val profilMua = BuildConfig.BASE_URL+"assets/img/mua/paket/" + detailpaket.foto
        Glide.with(this)
            .load(profilMua)
            .into(ivPaketMua)
    }
}