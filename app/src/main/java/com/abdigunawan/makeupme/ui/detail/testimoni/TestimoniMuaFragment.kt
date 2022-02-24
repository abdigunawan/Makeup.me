package com.abdigunawan.makeupme.ui.detail.testimoni

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.dummy.MuaJadwalModel
import com.abdigunawan.makeupme.model.dummy.MuaTestimoniModel
import com.abdigunawan.makeupme.model.response.home.testimoni.HomeTestimoniResponse
import com.abdigunawan.makeupme.model.response.home.testimoni.Testimoni
import com.abdigunawan.makeupme.ui.detail.DetailMuaActivity
import kotlinx.android.synthetic.main.fragment_testimoni_mua.*

class TestimoniMuaFragment : Fragment(),TestimoniMuaAdapter.ItemAdapterCallback, TestimoniContract.View {

    private var adapter : TestimoniMuaAdapter? = null
    var progressDialog: Dialog? = null
    private lateinit var presenter: TestimoniPresenter
    private lateinit var getData: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_testimoni_mua, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val activity: DetailMuaActivity? = activity as DetailMuaActivity?
        getData = activity!!.sendDataId()

        presenter = TestimoniPresenter(this)
        presenter.getTestimoni(getData)


    }
    override fun onClick(v: View, data: Testimoni) {

    }

    override fun onTestimoniSuccess(homeTestimoniResponse: HomeTestimoniResponse) {

        adapter = TestimoniMuaAdapter(homeTestimoniResponse.testimoni, this)
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcTestimoniMua.layoutManager = layoutManager
        rcTestimoniMua.adapter = adapter

        if (homeTestimoniResponse.testimoni.isNullOrEmpty()) {
            rcTestimoniMua.visibility = View.GONE
            ll_empty.visibility = View.VISIBLE
        } else {
            rcTestimoniMua.visibility = View.VISIBLE
            ll_empty.visibility = View.GONE
        }

    }

    override fun onTestimoniFailed(message: String) {
        SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("GAGAL MEMUAT TESTIMONI")
            .setContentText(message)
            .show()
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()
    }

}