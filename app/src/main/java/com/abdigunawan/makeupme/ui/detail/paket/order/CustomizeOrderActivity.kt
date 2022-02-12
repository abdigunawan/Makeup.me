package com.abdigunawan.makeupme.ui.detail.paket.order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.abdigunawan.makeupme.R
import com.readystatesoftware.chuck.internal.ui.MainActivity
import kotlinx.android.synthetic.main.activity_customize_order.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class CustomizeOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customize_order)
        initListener()
        initToolbar()

    }

    private fun initListener(){
        btnSelanjutnya.setOnClickListener {
            val payment = Intent(this, PaymentActivity::class.java)
            startActivity(payment)
        }
    }

    private fun initToolbar() {
        toolbar.title = "Jam Dan Tanggal";
        toolbar.subtitle = "Kapan tanggal dan jam acaramu?"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}