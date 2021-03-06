package com.abdigunawan.makeupme.ui.order.detailbatal

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import cn.pedant.SweetAlert.SweetAlertDialog
import com.abdigunawan.makeupme.BuildConfig
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.order.Transaksiuser
import com.abdigunawan.makeupme.utils.Helpers.formatPrice
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_order.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.text.SimpleDateFormat

class DetailOrderActivity : AppCompatActivity() {

//    lateinit var presenter : FinishOrderPresenter
    var progressDialog: Dialog? = null
    private val detailtransaksi by lazy { intent.getSerializableExtra("detailtransaksi") as Transaksiuser }
    val formatDate = SimpleDateFormat("dd MMMM YYYY")
    val formatHour = SimpleDateFormat("HH.mm")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_order)
//        presenter = FinishOrderPresenter(this)
        initToolbar()
        initDetail()
        initView()
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

    private fun initToolbar() {
        toolbar.title = "Detail Booking"
        toolbar.subtitle = "Temukan Wajah Terbaikmu"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun initDetail(){

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val simpleHourFormat = SimpleDateFormat("hh:mm:ss")

        tvTitle.text = detailtransaksi.transaksiuser.namaPaket
        tvPrice.formatPrice(detailtransaksi.transaksiuser.harga.toString())
        textView15.text = detailtransaksi.jumlah
        tvTotal.formatPrice(detailtransaksi.totalHarga)
        tvNama.text = detailtransaksi.transaksiuser.user.name
        tvPhone.text = detailtransaksi.transaksiuser.user.noHp
        tvAddress.text = detailtransaksi.transaksiuser.user.alamat
        tvHouseNo.text = detailtransaksi.transaksiuser.user.noRumah
        val date = simpleDateFormat.parse(detailtransaksi.tanggalAcara)
        val hour = simpleHourFormat.parse(detailtransaksi.jamAcara)
        tvtanggalKetemu.text = formatDate.format(date)
        tvJamKetemu.text = formatHour.format(hour)
        tvCatatan.text = detailtransaksi.catatan
        tvStatus.text = detailtransaksi.status

        if (detailtransaksi.status.equals("DIBATALKAN")) {
            tvStatus.setTextColor(Color.RED)
        }

        val fotopaket = BuildConfig.BASE_URL+"assets/img/mua/paket/" + detailtransaksi.transaksiuser.foto
        Glide.with(this)
            .load(fotopaket)
            .apply(RequestOptions.centerCropTransform())
            .into(ivPoster)

    }

//    override fun onFinishSuccess(message: String) {
//        finish()
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onFinishFailed(message: String) {
//        SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
//            .setTitleText("Opss!!")
//            .setContentText(message)
//            .show()
//    }
//
//    override fun showLoading() {
//        progressDialog?.show()
//    }
//
//    override fun dismissLoading() {
//        progressDialog?.dismiss()
//    }
}