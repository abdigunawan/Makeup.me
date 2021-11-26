package com.abdigunawan.makeupme.ui.seeall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.dummy.HomeModel
import com.abdigunawan.makeupme.ui.detail.DetailMuaActivity
import kotlinx.android.synthetic.main.activity_lihat_semua_mua.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class LihatSemuaMuaActivity : AppCompatActivity() {

    private var muaList : ArrayList<HomeModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_semua_mua)
        
        val title = intent.getStringExtra("title")

        toolbar.title = title
        toolbar.subtitle = "Temukan Wajah Terbaikmu"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        initDataDummy()
        var adapter = LihatSemuaMuaAdapter(muaList, this)
        var layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter
    }

    fun initDataDummy() {
        muaList = ArrayList()
        muaList.add(HomeModel("Adella Dewi Cahayani", "Perintis Kemerdekaan VII", "", 5f))
        muaList.add(HomeModel("Masih Adella", "Perintis Kemerdekaan VII", "", 4f))
        muaList.add(HomeModel("Adella Lagi", "Perintis Kemerdekaan VII", "", 4.5f))
        muaList.add(HomeModel("Bukanmi Adella Ini", "Perintis Kemerdekaan VII", "", 4.5f))
        muaList.add(HomeModel("Adella Dewi Cahayani", "Perintis Kemerdekaan VII", "", 5f))
        muaList.add(HomeModel("Masih Adella", "Perintis Kemerdekaan VII", "", 4f))
        muaList.add(HomeModel("Adella Lagi", "Perintis Kemerdekaan VII", "", 4.5f))
        muaList.add(HomeModel("Bukanmi Adella Ini", "Perintis Kemerdekaan VII", "", 4.5f))
    }

    fun onClick(it: View?, data: HomeModel) {
        val detailmua = Intent(this, DetailMuaActivity::class.java)
        startActivity(detailmua)
    }
}