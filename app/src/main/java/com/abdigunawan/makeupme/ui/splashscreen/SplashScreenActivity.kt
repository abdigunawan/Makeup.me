package com.abdigunawan.makeupme.ui.splashscreen

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.ui.onboarding.OnBoardingActivity

class SplashScreenActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
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