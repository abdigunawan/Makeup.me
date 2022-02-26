package com.abdigunawan.makeupme.ui.order.detailselesai

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import cn.pedant.SweetAlert.SweetAlertDialog
import com.abdigunawan.makeupme.BuildConfig
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.orderselesai.Transaksiuser
import com.abdigunawan.makeupme.ui.order.beritestimoni.BeriTestimoniActivity
import com.abdigunawan.makeupme.utils.Helpers.formatPrice
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_selesai_order.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.text.SimpleDateFormat

class DetailSelesaiOrderActivity : AppCompatActivity() {

    private val detailtransaksi by lazy { intent.getSerializableExtra("detailtransaksi") as Transaksiuser }
    val formatDate = SimpleDateFormat("dd MMMM YYYY")
    val formatHour = SimpleDateFormat("HH.mm")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_selesai_order)
        initToolbar()
        initListener()
        initDetail()
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
        tvHouseNo.text = detailtransaksi.konfirmasitransaksi[0].lokasi
        val date = simpleDateFormat.parse(detailtransaksi.konfirmasitransaksi[0].tanggalKetemu)
        val hour = simpleHourFormat.parse(detailtransaksi.konfirmasitransaksi[0].jamKetemu)
        tvtanggalKetemu.text = formatDate.format(date)
        tvJamKetemu.text = formatHour.format(hour)
        tvCatatan.text = detailtransaksi.konfirmasitransaksi[0].catatan
        tvStatus.text = detailtransaksi.status

        val fotopaket = BuildConfig.BASE_URL+"assets/img/mua/paket/" + detailtransaksi.transaksiuser.foto
        Glide.with(this)
            .load(fotopaket)
            .apply(RequestOptions.centerCropTransform())
            .into(ivPoster)

    }

    private fun initListener() {

        btnTestimoni.setOnClickListener {
            val testimoni = Intent(this,BeriTestimoniActivity::class.java).putExtra("transaksiid", detailtransaksi.konfirmasitransaksi[0].id.toString())
            startActivity(testimoni)
        }
    }
}