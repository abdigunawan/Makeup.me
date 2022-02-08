package com.abdigunawan.makeupme.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.model.dummy.HomeModel
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.ui.detail.DetailMuaActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),HomeAdapter.ItemAdapterCallback {

    private var muaList : ArrayList<HomeModel> = ArrayList()
    private var muaList2 : ArrayList<HomeModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = HomeAdapter(muaList, this)
        var adapternewyou = HomeAdapter(muaList, this)

        var layoutManager : RecyclerView.LayoutManager = GridLayoutManager(context,2)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter

    }

    fun initDataDummy(){
        muaList = ArrayList()
        muaList.add(HomeModel("Adella Dewi Cahayani","Perintis Kemerdekaan VII","",5f))
        muaList.add(HomeModel("Masih Adella","Perintis Kemerdekaan VII","",4f))
        muaList.add(HomeModel("Adella Lagi","Perintis Kemerdekaan VII","",4.5f))
        muaList.add(HomeModel("Bukanmi Adella Ini","Perintis Kemerdekaan VII","",4.5f))
        muaList.add(HomeModel("Adella Dewi Cahayani","Perintis Kemerdekaan VII","",5f))
        muaList.add(HomeModel("Masih Adella","Perintis Kemerdekaan VII","",4f))
        muaList.add(HomeModel("Adella Lagi","Perintis Kemerdekaan VII","",4.5f))
        muaList.add(HomeModel("Bukanmi Adella Ini","Perintis Kemerdekaan VII","",4.5f))

        muaList2 = ArrayList()
        muaList2.add(HomeModel("Adella Dewi Cahayani","Perintis Kemerdekaan VII","",5f))
        muaList2.add(HomeModel("Masih Adella","Perintis Kemerdekaan VII","",4f))
        muaList2.add(HomeModel("Adella Lagi","Perintis Kemerdekaan VII","",4.5f))
        muaList2.add(HomeModel("Bukanmi Adella Ini","Perintis Kemerdekaan VII","",4.5f))
        muaList2.add(HomeModel("Adella Dewi Cahayani","Perintis Kemerdekaan VII","",5f))
        muaList2.add(HomeModel("Masih Adella","Perintis Kemerdekaan VII","",4f))
        muaList2.add(HomeModel("Adella Lagi","Perintis Kemerdekaan VII","",4.5f))
        muaList2.add(HomeModel("Bukanmi Adella Ini","Perintis Kemerdekaan VII","",4.5f))


    }

    override fun onClick(v: View, data: HomeModel) {
        val detailmua = Intent(activity, DetailMuaActivity::class.java)
        startActivity(detailmua)
    }
}