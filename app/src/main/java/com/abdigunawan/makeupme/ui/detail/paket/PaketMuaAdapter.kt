package com.abdigunawan.makeupme.ui.detail.paket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.utils.Helpers.formatPrice
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.dummy.MuaPaketModel
import com.abdigunawan.makeupme.ui.profile.ProfileMenuAdapter
import kotlinx.android.synthetic.main.item_paket_horizontal.view.*

class PaketMuaAdapter(
    private val listData: List<MuaPaketModel>,
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
        fun bind(data: MuaPaketModel, itemAdapterCallBack: ItemAdapterCallback) {
            itemView.apply {
                tvNamaPaket.text = data.title
                tvHarga.formatPrice(data.price)

//                Glide.with(context)
//                    .load(data.src)
//                    .into(ivPoster)

                itemView.setOnClickListener { itemAdapterCallBack.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback{
        fun onClick(v: View, data: MuaPaketModel)
    }
}