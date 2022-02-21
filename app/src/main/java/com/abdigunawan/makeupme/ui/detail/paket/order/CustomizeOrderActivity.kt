package com.abdigunawan.makeupme.ui.detail.paket.order

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.home.paket.Paket
import kotlinx.android.synthetic.main.activity_customize_order.*
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.text.SimpleDateFormat
import java.util.*

class CustomizeOrderActivity : AppCompatActivity() {

    private val detailpaket by lazy { intent.getSerializableExtra("detailpaket") as Paket }
    lateinit var senddate : String
    lateinit var sendtime : String
    val viewformatDate = SimpleDateFormat("dd MMMM YYYY")
    val viewformatHour = SimpleDateFormat("HH:mm")
    val sendformatDate = SimpleDateFormat("YYYY-MM-dd")
    val sendformatHour = SimpleDateFormat("HH:mm:ss")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customize_order)
        initListener()
        initToolbar()
        getTanggal()
        getJam()

    }

    private fun initListener(){

            btnSelanjutnya.setOnClickListener {

                var tanggalacara = etTanggalAcara.text.toString()
                var jamacara = etJamAcara.text.toString()
                var jumlah = etJumlah.text.toString()
                var catatan = etCatatan.text.toString()

                if (tanggalacara.isNullOrEmpty()) {
                    etTanggalAcara.error = "Masukkan Tanggal Ketemu"
                    etTanggalAcara.requestFocus()
                } else if (jamacara.isNullOrEmpty()) {
                    etJamAcara.error = "Masukkan Jam Acara Dulu"
                    etJamAcara.requestFocus()
                } else if (jumlah.isNullOrEmpty()) {
                    etJumlah.error = "Masukkan Jumlah Dulu"
                    etJumlah.requestFocus()
                } else if (catatan.isNullOrEmpty()) {
                    etCatatan.error = "Masukkan Catatan Dulu"
                    etCatatan.requestFocus()
                } else {
                    val payment = Intent(this, PaymentActivity::class.java)
                    val extras = Bundle()
                    extras.putString("tanggal", tanggalacara)
                    extras.putString("jam",jamacara)
                    extras.putString("jumlah", jumlah)
                    extras.putString("catatan",catatan)
                    extras.putString("kirimjam", sendtime)
                    extras.putString("kirimtanggal",senddate)
                    payment.putExtras(extras).putExtra("detailpaket",detailpaket)
                    startActivity(payment)
            }
        }

    }

    private fun initToolbar() {
        toolbar.title = "Jam Dan Tanggal";
        toolbar.subtitle = "Kapan tanggal dan jam acaramu?"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun getTanggal() {
        etTanggalAcara.setOnClickListener {
            val getDate = Calendar.getInstance()
            val dPickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->

                val c = Calendar.getInstance()
                c.set(Calendar.YEAR, i)
                c.set(Calendar.MONTH, i2)
                c.set(Calendar.DAY_OF_MONTH, i3)
                val date : String = viewformatDate.format(c.time)
                senddate = sendformatDate.format(c.time)

                etTanggalAcara.setText(date)
            }, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))

            dPickerDialog.show()
        }
    }

    private fun getJam() {
        etJamAcara.setOnClickListener {
            val gethour = Calendar.getInstance()
            val tsl = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                val cal = Calendar.getInstance()
                cal.set(Calendar.HOUR_OF_DAY, i)
                cal.set(Calendar.MINUTE, i2)
                val jam = viewformatHour.format(cal.time)
                sendtime = sendformatHour.format(cal.time)
                etJamAcara.setText(jam)
            }, gethour.get(Calendar.HOUR_OF_DAY),gethour.get(Calendar.MINUTE), true)

            tsl.show()
        }
    }
}