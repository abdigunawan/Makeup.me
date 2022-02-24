package com.abdigunawan.makeupme.ui.order.beritestimoni

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.abdigunawan.makeupme.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_beri_testimoni.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class BeriTestimoniActivity : AppCompatActivity(),BeriTestimoniContract.View {

    lateinit var presenter: BeriTestimoniPresenter
    var progressDialog: Dialog? = null
    var gambar: Uri?= null
    lateinit var transaksiId : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beri_testimoni)
        presenter = BeriTestimoniPresenter(this)
        var intent: Intent = getIntent()
        var extras = intent.extras
        transaksiId = extras?.getString("transaksiid")!!
        initTolbar()
        initListener()
        initView()
    }

    private fun initTolbar(){
        toolbar.title = "Beri Testimoni"
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
                etCatatan.error = "masukin komentar dongg kaak"
            } else if (gambar == null) {
                Toast.makeText(this, "Pilih Foto Dulu Dong kak", Toast.LENGTH_SHORT).show()
            }
            else {
                presenter.addTestimoni(transaksiId, saran, gambar!!)
            }
        }

        ivFoto.setOnClickListener {
            ImagePicker.with(this)
                .crop()
                .compress(1024)
                .maxResultSize(1920, 1080)
                .start()
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

    override fun onTestimoniSuccess(message: String) {
        SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText("YEAYYY!!!")
            .setContentText("Berhasil Kirim Testimoni")
            .setConfirmClickListener(SweetAlertDialog.OnSweetClickListener() {
                it.dismissWithAnimation()
                this.finish()
            })
            .show()
    }

    override fun onTestimoniFailed(message: String) {
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            gambar = data?.data

            Glide.with(this)
                .load(gambar)
                .apply(RequestOptions.centerCropTransform())
                .into(ivFoto)

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Pilih Foto Dibatallan", Toast.LENGTH_SHORT).show()
        }
    }

}