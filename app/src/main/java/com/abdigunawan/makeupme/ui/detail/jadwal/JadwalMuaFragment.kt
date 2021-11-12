package com.abdigunawan.makeupme.ui.detail.jadwal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.dummy.MuaJadwalModel
import kotlinx.android.synthetic.main.fragment_jadwal_mua.*

class JadwalMuaFragment : Fragment(),JadwalMuaAdapter.ItemAdapterCallback {

    private var menuArrayList : ArrayList<MuaJadwalModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal_mua, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = JadwalMuaAdapter(menuArrayList, this)
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcJadwalMua.layoutManager = layoutManager
        rcJadwalMua.adapter = adapter
    }

    fun initDataDummy() {
        menuArrayList = ArrayList()
        menuArrayList.add(MuaJadwalModel("Natalya Tolla", "Paket Wisuda", "", "Daya, Paccerakkang", "9 Nov, 13.00-14.00"))
        menuArrayList.add(MuaJadwalModel("Adella Dewi", "Paket Nikah", "", "Perintis Kemerdekaan 7", "10 Nov, 9.00-12.00"))
        menuArrayList.add(MuaJadwalModel("Nurul Fadillah", "Paket Nikah","", "Jalan Poros Bone Makassar","10 Nov, 13.00-14.00"))
        menuArrayList.add(MuaJadwalModel("Natalya Tolla", "Paket Wisuda", "", "Daya, Paccerakkang", "9 Nov, 13.00-14.00"))
        menuArrayList.add(MuaJadwalModel("Adella Dewi", "Paket Nikah", "", "Perintis Kemerdekaan 7","10 Nov, 9.00-12.00"))
        menuArrayList.add(MuaJadwalModel("Nurul Fadillah", "Paket Nikah" ,"", "Jalan Poros Bone Makassar", "10 Nov, 13.00-14.00"))

    }

    override fun onClick(v: View, data: MuaJadwalModel) {
        Toast.makeText(context, "Ini menu yang kamu klik "+ data.pelanggan, Toast.LENGTH_SHORT).show()
    }

}