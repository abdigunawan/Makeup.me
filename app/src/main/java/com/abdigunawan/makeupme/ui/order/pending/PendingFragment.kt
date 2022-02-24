package com.abdigunawan.makeupme.ui.order.pending

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
import com.abdigunawan.makeupme.model.response.order.RiwayatTransaksiResponse
import com.abdigunawan.makeupme.model.response.order.Transaksiuser
import com.abdigunawan.makeupme.ui.order.detailbatal.DetailOrderActivity
import com.abdigunawan.makeupme.ui.order.detailselesai.DetailSelesaiOrderActivity
import kotlinx.android.synthetic.main.fragment_pending.*
import java.util.*

class PendingFragment : Fragment(), PendingAdapter.ItemAdapterCallback, PendingContract.View {

    private var adapter: PendingAdapter? = null
    var progressDialog: Dialog? = null
    private lateinit var presenter: PendingPresenter
    val inprogressList : ArrayList<Transaksiuser> = ArrayList()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pending, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        initView()
        presenter = PendingPresenter(this)

    }

    override fun onResume() {
        super.onResume()
        presenter.getTransaction()
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

    override fun onClick(v: View?, data: Transaksiuser) {

        val detail = Intent(activity, DetailOrderActivity::class.java).putExtra("detailtransaksi", data)
        startActivity(detail)
    }

    override fun onTransactionSuccess(riwayatTransaksiResponse: RiwayatTransaksiResponse) {

        inprogressList.clear()

        riwayatTransaksiResponse.transaksiuser.forEach {
            if (it.status.equals("PENDING")) {
                inprogressList.add(it)
            }
        }
        adapter = PendingAdapter(inprogressList, this)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter

        if (inprogressList.isNullOrEmpty()) {
            rcList.visibility = View.GONE
            ll_empty.visibility = View.VISIBLE
        } else {
            rcList.visibility = View.VISIBLE
            ll_empty.visibility = View.GONE
        }
    }

    override fun onTransactionFailed(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()
    }
}