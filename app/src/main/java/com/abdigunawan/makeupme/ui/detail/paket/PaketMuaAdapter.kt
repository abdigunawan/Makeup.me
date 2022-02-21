package com.abdigunawan.makeupme.ui.detail.paket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.BuildConfig
import com.abdigunawan.makeupme.utils.Helpers.formatPrice
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.home.paket.Paket
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_paket_horizontal.view.*
import kotlinx.android.synthetic.main.item_paket_horizontal.view.ivProfilMua

class PaketMuaAdapter(
    private val listData: List<Paket>,
    private val itemAdapterCallBack: ItemAdapterCallback,
) : RecyclerView.Adapter<PaketMuaAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaketMuaAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_paket_horizontal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaketMuaAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position],itemAdapterCallBack)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Paket, itemAdapterCallBack: ItemAdapterCallback) {
            itemView.apply {
                tvNamaPaket.text = data.namaPaket
                tvHarga.formatPrice(data.harga.toString())
                if (!data.foto.isNullOrEmpty()) {
                    val fotopaket = BuildConfig.BASE_URL+"assets/img/mua/paket/" + data.foto
                    Glide.with(context)
                        .load(fotopaket)
                        .into(ivProfilMua)
                }

                itemView.setOnClickListener { itemAdapterCallBack.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback{
        fun onClick(v: View, data: Paket)
    }
}