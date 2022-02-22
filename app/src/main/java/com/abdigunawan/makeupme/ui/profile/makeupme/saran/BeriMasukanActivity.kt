package com.abdigunawan.makeupme.ui.profile.makeupme.saran

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.pedant.SweetAlert.SweetAlertDialog
import com.abdigunawan.makeupme.R
import kotlinx.android.synthetic.main.activity_beri_masukan.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class BeriMasukanActivity : AppCompatActivity(),BeriMasukanContract.View {

    lateinit var presenter: BeriMasukanPresenter
    var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beri_masukan)
        presenter = BeriMasukanPresenter(this)
        initTolbar()
        initListener()
        initView()
    }

    private fun initTolbar(){
        toolbar.title = "Beri Masukan"
        toolbar.subtitle = "Temukan Wajah Terbaikmu"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun initListener() {
        btnSimpanSaran.setOnClickListener {

            var saran = etCatatan.text.toString()

            if (saran.isNullOrEmpty()) {
                etCatatan.error = "masukin kritik dan saran dulu dongg kaak"
            } else {
                presenter.submitSaran(null, saran)
            }
        }
    }

    private fun initView() {
        progressDialog = Dialog(this)
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)
        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    override fun onBeriMasukanSuccess(message: String) {
        SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText("YEAYYY!!!")
            .setContentText(message)
            .setConfirmClickListener(SweetAlertDialog.OnSweetClickListener() {
                it.dismissWithAnimation()
                this.finish()
            })
            .show()
    }

    override fun onBeriMasukanFailed(message: String) {
        SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("UPSSS!!!")
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