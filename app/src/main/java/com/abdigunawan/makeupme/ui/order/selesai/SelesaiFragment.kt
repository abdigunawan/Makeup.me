package com.abdigunawan.makeupme.ui.order.selesai

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.orderselesai.OrderSelesaiTransaksiResponse
import com.abdigunawan.makeupme.model.response.orderselesai.Transaksiuser
import com.abdigunawan.makeupme.ui.order.detailselesai.DetailSelesaiOrderActivity
import kotlinx.android.synthetic.main.fragment_selesai.*
import java.util.*

class SelesaiFragment : Fragment(), SelesaiAdapter.ItemAdapterCallback, SelesaiContract.View {

    private var adapter: SelesaiAdapter? = null
    var progressDialog: Dialog? = null
    private lateinit var presenter: SelesaiPresenter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selesai, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        initView()
        presenter = SelesaiPresenter(this)

    }

    override fun onResume() {
        super.onResume()
        presenter.getSelesai()
    }

    private fun initView() {
        progressDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)

        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    override fun onSelesaiSuccess(orderSelesaiTransaksiResponse: OrderSelesaiTransaksiResponse) {
        adapter = SelesaiAdapter(orderSelesaiTransaksiResponse.transaksiuser, this)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter

        if (orderSelesaiTransaksiResponse.transaksiuser.isNullOrEmpty()) {
            rcList.visibility = View.GONE
            ll_empty.visibility = View.VISIBLE
        } else {
            rcList.visibility = View.VISIBLE
            ll_empty.visibility = View.GONE
        }
    }

    override fun onSelesaiFailed(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()
    }

    override fun onClick(v: View?, data: Transaksiuser) {
        val detail = Intent(activity, DetailSelesaiOrderActivity::class.java).putExtra("detailtransaksi", data)
        startActivity(detail)
    }

}