package com.abdigunawan.makeupme.ui.detail.paket.order

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import com.abdigunawan.makeupme.BuildConfig
import com.abdigunawan.makeupme.Makeupme
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.home.paket.Paket
import com.abdigunawan.makeupme.model.response.login.User
import com.abdigunawan.makeupme.ui.home.HomeFragment
import com.abdigunawan.makeupme.utils.Helpers.formatPrice
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.layout_toolbar.*


class PaymentActivity : AppCompatActivity(), PaymentContract.View {

    private val detailpaket by lazy { intent.getSerializableExtra("detailpaket") as Paket }
    lateinit var presenter : PaymentPresenter
    var progressDialog: Dialog? = null
    lateinit var jumlah : String
    lateinit var kirimtanggal : String
    lateinit var kirimjam : String
    lateinit var catatan : String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)


        presenter = PaymentPresenter(this)
        initToolbar()
        initListener()
        initView()
    }

    private fun initToolbar() {
        toolbar.title = "Periksa Pesanan"
        toolbar.subtitle = "Pastikan Kembali Pesananmu benar"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun initView() {

        var intent: Intent = getIntent()
        var extras = intent.extras
        var tanggalacara: String = extras?.getString("tanggal")!!
        var jamacara: String = extras.getString("jam")!!
        jumlah = extras.getString("jumlah")!!
        catatan = extras.getString("catatan")!!
        kirimjam = extras.getString("kirimjam")!!
        kirimtanggal = extras.getString("kirimtanggal")!!

        var user = Makeupme.getApp().getUser()
        var userResponse = Gson().fromJson(user, User::class.java)
        var totalBayar = jumlah.toString().toInt() * detailpaket.harga

        tvTitle.text = detailpaket.namaPaket
        tvPrice.formatPrice(detailpaket.harga.toString())
        textView15.text = jumlah
        tvTotal.formatPrice(totalBayar.toString())
        tvNama.text = userResponse.name
        tvAddress.text = userResponse.alamat
        tvHouseNo.text = userResponse.noRumah
        tvTanggalacara.text = tanggalacara
        tvJamAcara.text = jamacara
        tvCatatan.text = catatan

        val fotopaket = BuildConfig.BASE_URL+"assets/img/mua/paket/" + detailpaket.foto
        Glide.with(this)
            .load(fotopaket)
            .apply(RequestOptions.centerCropTransform())
            .into(ivPoster)

        progressDialog = Dialog(this)
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)
        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }

    }

    private fun initListener(){
        btnCheckout.setOnClickListener {

            presenter.addTransaksi(
                detailpaket.id.toString(),
                jumlah,
                kirimtanggal,
                kirimjam,
                catatan
            )
        }
    }

    override fun onPaymentSuccess(message: String) {
        SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText("SUKSES")
            .setContentText(message)
            .setConfirmClickListener(SweetAlertDialog.OnSweetClickListener() {
                it.dismissWithAnimation()
                val home = Intent(this, com.abdigunawan.makeupme.ui.MainActivity::class.java)
                startActivity(home)
            })
            .show()
    }

    override fun onPaymentFailed(message: String) {
        SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("GAGAL")
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