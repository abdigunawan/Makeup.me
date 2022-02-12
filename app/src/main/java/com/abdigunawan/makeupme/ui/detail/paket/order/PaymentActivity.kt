package com.abdigunawan.makeupme.ui.detail.paket.order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdigunawan.makeupme.R
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        initToolbar()
        initListener()
    }

    private fun initToolbar() {
        toolbar.title = "Periksa Pesanan"
        toolbar.subtitle = "Pastikan Kembali Pesananmu benar"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun initListener(){
        btnCheckout.setOnClickListener {
            val success = Intent(this, PaymentActivity::class.java)
            startActivity(success)
        }
    }
}