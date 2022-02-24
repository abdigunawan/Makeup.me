package com.abdigunawan.makeupme.ui.home

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.isNotEmpty
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.abdigunawan.makeupme.Makeupme
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.home.HomeGetMuaResponse
import com.abdigunawan.makeupme.model.response.home.Kota
import com.abdigunawan.makeupme.model.response.login.User
import com.abdigunawan.makeupme.ui.detail.DetailMuaActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment(),HomeAdapter.ItemAdapterCallback, HomeContract.View {

    private var adapter : HomeAdapter? = null
    var progressDialog: Dialog? = null
    private lateinit var presenter: HomePresenter
    val tempArrayList : ArrayList<Kota> = ArrayList()

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

        initView()
        presenter = HomePresenter(this)
        presenter.getHome()

    }

    override fun onResume() {
        super.onResume()
        presenter.getHome()
    }

    private fun initView() {
        var user = Makeupme.getApp().getUser()
        var userResponse = Gson().fromJson(user, User::class.java)

        tvKota.setText("Makeup Artist Di " + userResponse.kota)

        progressDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)

        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }


    override fun onClick(v: View, data: Kota) {
        val detailmua = Intent(activity, DetailMuaActivity::class.java).putExtra("detailmua", data)
        startActivity(detailmua)
    }

    override fun onHomeSuccess(homeGetMuaResponse: HomeGetMuaResponse) {

        tempArrayList.clear()
        adapter = HomeAdapter(tempArrayList, this)
        var layoutManager : RecyclerView.LayoutManager = GridLayoutManager(context,2)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter
        tempArrayList.addAll(homeGetMuaResponse.kota)

        if (homeGetMuaResponse.kota.isNullOrEmpty()) {
            ivKosong.visibility = View.VISIBLE
            tvKosong.visibility = View.VISIBLE
        } else {
            ivKosong.visibility = View.GONE
            tvKosong.visibility = View.GONE
        }

        etSearch.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (etSearch!!.isNotEmpty()){
                    tempArrayList.clear()
                    val search = newText?.lowercase(Locale.getDefault())
                    homeGetMuaResponse.kota.forEach {
                        if (it.name.lowercase(Locale.getDefault()).contains(search!!) || it.alamat.lowercase(Locale.getDefault()).contains(search)) {
                            tempArrayList.add(it)
                        }
                    }
                    rcList.adapter!!.notifyDataSetChanged()
                } else {
                    tempArrayList.clear()
                    tempArrayList.addAll(homeGetMuaResponse.kota)
                    rcList.adapter!!.notifyDataSetChanged()
                }
                return true
            }
        })
    }

    override fun onHomeFailed(message: String) {
        SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("GAGAL MEMUAT MUA")
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