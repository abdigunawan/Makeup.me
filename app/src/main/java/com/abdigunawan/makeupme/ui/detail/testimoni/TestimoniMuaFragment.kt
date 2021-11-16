package com.abdigunawan.makeupme.ui.detail.testimoni

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
import com.abdigunawan.makeupme.model.dummy.MuaTestimoniModel
import com.abdigunawan.makeupme.ui.detail.jadwal.JadwalMuaAdapter
import kotlinx.android.synthetic.main.fragment_jadwal_mua.*
import kotlinx.android.synthetic.main.fragment_testimoni_mua.*

class TestimoniMuaFragment : Fragment(),TestimoniMuaAdapter.ItemAdapterCallback {

    private var menuArrayList : ArrayList<MuaTestimoniModel> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_testimoni_mua, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = TestimoniMuaAdapter(menuArrayList, this)
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcTestimoniMua.layoutManager = layoutManager
        rcTestimoniMua.adapter = adapter
    }

    fun initDataDummy() {
        menuArrayList = ArrayList()
        menuArrayList.add(MuaTestimoniModel("Abdi Gunawan", "", "Komentar : terimakasih kak suka banget sama produknya\uD83D\uDE18❤","16 Nov 2021"))
        menuArrayList.add(MuaTestimoniModel("Abdi Gunawan", "", "Komentar : terimakasih kak suka banget sama produknya\uD83D\uDE18❤","16 Nov 2021"))
        menuArrayList.add(MuaTestimoniModel("Abdi Gunawan", "", "Komentar : terimakasih kak suka banget sama produknya\uD83D\uDE18❤","16 Nov 2021"))
        menuArrayList.add(MuaTestimoniModel("Abdi Gunawan", "", "Komentar : terimakasih kak suka banget sama produknya\uD83D\uDE18❤","16 Nov 2021"))
        menuArrayList.add(MuaTestimoniModel("Abdi Gunawan", "", "Komentar : terimakasih kak suka banget sama produknya\uD83D\uDE18❤","16 Nov 2021"))
        menuArrayList.add(MuaTestimoniModel("Abdi Gunawan", "", "Komentar : terimakasih kak suka banget sama produknya\uD83D\uDE18❤","16 Nov 2021"))
        menuArrayList.add(MuaTestimoniModel("Abdi Gunawan", "", "Komentar : terimakasih kak suka banget sama produknya\uD83D\uDE18❤","16 Nov 2021"))
        menuArrayList.add(MuaTestimoniModel("Abdi Gunawan", "", "Komentar : terimakasih kak suka banget sama produknya\uD83D\uDE18❤","16 Nov 2021"))
    }

    override fun onClick(v: View, data: MuaTestimoniModel) {
        Toast.makeText(context, "Ini menu yang kamu klik "+ data.pelanggan, Toast.LENGTH_SHORT).show()
    }

}