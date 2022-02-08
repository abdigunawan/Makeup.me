package com.abdigunawan.makeupme.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.abdigunawan.makeupme.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class DetailMuaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mua)

        val pageRequest = intent.getIntExtra("page_request", 0)
        if (pageRequest == 4) {
            toolbarDetailMua()
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.fragmentDetailMua, true).build()

            Navigation.findNavController(findViewById(R.id.detailHostFragment)).navigate(R.id.action_fragmentDetailMua_to_fragmentDetailPaket, null,navOptions)
        }
    }

    fun toolbarDetailMua() {
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_fff, null)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    fun toolbarPayment() {
        toolbar.visibility = View.GONE
    }

}