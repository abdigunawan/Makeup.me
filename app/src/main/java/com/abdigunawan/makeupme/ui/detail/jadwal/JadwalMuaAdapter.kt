package com.abdigunawan.makeupme.ui.detail.jadwal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.dummy.MuaJadwalModel
import kotlinx.android.synthetic.main.item_jadwal_vertical.view.*

class JadwalMuaAdapter(
    private val listData: List<MuaJadwalModel>,
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
        fun bind(data: MuaJadwalModel, itemAdapterCallBack: ItemAdapterCallback) {
            itemView.apply {
                tvPelanggan.text = data.pelanggan
                tvPaketDipesan.text = data.paket
                tvAlamatKetemu.text = data.alamat
                tvTanggalPesanan.text = data.tanggal

//                Glide.with(context)
//                    .load(data.src)
//                    .into(ivPoster)

                itemView.setOnClickListener { itemAdapterCallBack.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback{
        fun onClick(v: View, data: MuaJadwalModel)
    }
}