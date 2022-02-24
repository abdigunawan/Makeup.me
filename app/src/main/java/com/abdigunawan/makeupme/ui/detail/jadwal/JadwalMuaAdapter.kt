package com.abdigunawan.makeupme.ui.detail.jadwal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.BuildConfig
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.dummy.MuaJadwalModel
import com.abdigunawan.makeupme.model.response.home.jadwal.Jadwal
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_jadwal_vertical.view.*
import kotlinx.android.synthetic.main.item_jadwal_vertical.view.tvPelanggan
import kotlinx.android.synthetic.main.item_testimoni_horizontal.view.*
import java.text.SimpleDateFormat

class JadwalMuaAdapter(
    private val listData: List<Jadwal>,
    private val itemAdapterCallBack: ItemAdapterCallback,
) : RecyclerView.Adapter<JadwalMuaAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalMuaAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_jadwal_vertical, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: JadwalMuaAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position],itemAdapterCallBack)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Jadwal, itemAdapterCallBack: ItemAdapterCallback) {
            itemView.apply {
                tvPelanggan.text = data.user.name
                tvPaketDipesan.text = data.transaksiuser.namaPaket
                tvAlamatKetemu.text = data.user.alamat + ", " + data.user.noRumah
                var formatDate = SimpleDateFormat("dd MMM yyyy, hh:mm")
                val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                val date = simpleDateFormat.parse(data.tanggalTransaksi)
                tvTanggalPesanan.text = formatDate.format(date)

                if (!data.transaksiuser.foto.isNullOrEmpty()) {
                    val jadwalmua = BuildConfig.BASE_URL + "assets/img/mua/paket/" + data.transaksiuser.foto
                    Glide.with(context)
                        .load(jadwalmua)
                        .into(ivPaketMua)
                }
                itemView.setOnClickListener { itemAdapterCallBack.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback{
        fun onClick(v: View, data: Jadwal)
    }
}