package com.abdigunawan.makeupme.ui.detail.jadwal

import android.app.Dialog
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
import com.abdigunawan.makeupme.model.response.home.jadwal.HomeJadwalResponse
import com.abdigunawan.makeupme.model.response.home.jadwal.Jadwal
import com.abdigunawan.makeupme.ui.detail.DetailMuaActivity
import com.abdigunawan.makeupme.ui.detail.testimoni.TestimoniPresenter
import kotlinx.android.synthetic.main.fragment_jadwal_mua.*

class JadwalMuaFragment : Fragment(),JadwalMuaAdapter.ItemAdapterCallback, JadwalContract.View {

    private var adapter : JadwalMuaAdapter? = null
    var progressDialog: Dialog? = null
    private lateinit var presenter: JadwalPresenter
    private lateinit var getData: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal_mua, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val activity: DetailMuaActivity? = activity as DetailMuaActivity?
        getData = activity!!.sendDataId()

        presenter = JadwalPresenter(this)
        presenter.getJadwal(getData)
    }

    override fun onClick(v: View, data: Jadwal) {
    }

    override fun onJadwalSuccess(homeJadwalResponse: HomeJadwalResponse) {
        var adapter = JadwalMuaAdapter(homeJadwalResponse.jadwal, this)
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcJadwalMua.layoutManager = layoutManager
        rcJadwalMua.adapter = adapter

        if (homeJadwalResponse.jadwal.isNullOrEmpty()) {
            rcJadwalMua.visibility = View.GONE
            ll_empty.visibility = View.VISIBLE
        } else {
            rcJadwalMua.visibility = View.VISIBLE
            ll_empty.visibility = View.GONE
        }
    }

    override fun onJadwalFailed(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()
    }

}