package com.abdigunawan.makeupme.ui.detail.paket

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.home.paket.MuaPaketResponse
import com.abdigunawan.makeupme.model.response.home.paket.Paket
import com.abdigunawan.makeupme.ui.detail.DetailMuaActivity
import com.abdigunawan.makeupme.ui.detail.paket.detail.DetailPaketActivity
import kotlinx.android.synthetic.main.fragment_paket_mua.*

class PaketMuaFragment : Fragment(),PaketMuaAdapter.ItemAdapterCallback, PaketContract.View {

    private var adapter : PaketMuaAdapter? = null
    var progressDialog: Dialog? = null
    private lateinit var presenter: PaketPresenter
    private lateinit var getData: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paket_mua, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val activity: DetailMuaActivity? = activity as DetailMuaActivity?
        getData = activity!!.sendDataId()

        initView()
        presenter = PaketPresenter(this)
        presenter.getPaket(getData)

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


    override fun onClick(v: View, data: Paket) {
        val detailpaket = Intent(activity, DetailPaketActivity::class.java).putExtra("detailpaket", data)
        startActivity(detailpaket)
    }

    override fun onPaketSuccess(muaPaketResponse: MuaPaketResponse) {

        adapter = PaketMuaAdapter(muaPaketResponse.paket, this)
        var layoutManager : RecyclerView.LayoutManager = GridLayoutManager(context,2)
        rcList2.layoutManager = layoutManager
        rcList2.adapter = adapter
    }

    override fun onPaketFailed(message: String) {
        SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("GAGAL MEMUAT PAKET")
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