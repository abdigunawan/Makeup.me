package com.abdigunawan.makeupme.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.ui.onboarding.OnBoardingActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val auth = Intent(this@SplashScreenActivity, OnBoardingActivity::class.java)
            startActivity(auth)
            finish()
        }, 3000)
    }
}