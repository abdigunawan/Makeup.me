package com.abdigunawan.makeupme.ui.profile.makeupme

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdigunawan.makeupme.R
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        toolbar.title = "Tentang"
        toolbar.subtitle = "Tentang Aplikasi makeup.me"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        igAbdiGunawan.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_abdigunawan/"))
            startActivity(intent)
        }
        igAdella.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/adelladewi.cahayani/"))
            startActivity(intent)
        }
        waAbdi.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.link/zx6lta"))
            startActivity(intent)
        }
        waAdella.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.link/l3tdpe"))
            startActivity(intent)
        }

    }
}