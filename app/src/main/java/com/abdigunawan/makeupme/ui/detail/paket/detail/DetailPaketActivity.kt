package com.abdigunawan.makeupme.ui.detail.paket.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.ui.detail.paket.order.CustomizeOrderActivity
import com.readystatesoftware.chuck.internal.ui.MainActivity
import kotlinx.android.synthetic.main.activity_detail_paket.*

class DetailPaketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_paket)
        initListener()
    }

    private fun initListener() {

        btnOrderNow.setOnClickListener {
            val custom = Intent(this, CustomizeOrderActivity::class.java)
            startActivity(custom)
        }

        ivBack.setOnClickListener {
            onBackPressed()
        }

    }
}