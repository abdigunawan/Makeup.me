package com.abdigunawan.makeupme.ui.detail.paket

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.dummy.MuaPaketModel
import com.abdigunawan.makeupme.ui.detail.DetailMuaActivity
import kotlinx.android.synthetic.main.fragment_home.*

class PaketMuaFragment : Fragment(),PaketMuaAdapter.ItemAdapterCallback {

    private var paketList : ArrayList<MuaPaketModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paket_mua, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = PaketMuaAdapter(paketList, this)
        var layoutManager : RecyclerView.LayoutManager = GridLayoutManager(context,2)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter

    }
    fun initDataDummy(){
        paketList = ArrayList()
        paketList.add(MuaPaketModel("Paket Wisuda","289000",""))
        paketList.add(MuaPaketModel("Paket Pernikahan","350000",""))
        paketList.add(MuaPaketModel("Paket Tamu Pernikahan","300000",""))
        paketList.add(MuaPaketModel("Paket Wisuda","289000",""))
        paketList.add(MuaPaketModel("Paket Pernikahan","350000",""))
        paketList.add(MuaPaketModel("Paket Tamu Pernikahan","300000",""))
    }

    override fun onClick(v: View, data: MuaPaketModel) {
        val detailpaket = Intent(activity, DetailMuaActivity::class.java)
        detailpaket.putExtra("page_request", 2)
        startActivity(detailpaket)
    }

}