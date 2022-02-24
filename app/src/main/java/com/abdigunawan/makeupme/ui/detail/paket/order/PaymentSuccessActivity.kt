package com.abdigunawan.makeupme.ui.detail.paket.order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.ui.MainActivity
import kotlinx.android.synthetic.main.activity_payment_success.*

class PaymentSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_success)
        initListener()
    }

    private fun initListener(){
        btnHome.setOnClickListener {
            var home = Intent(this, MainActivity::class.java)
            startActivity(home)
        }
    }
}