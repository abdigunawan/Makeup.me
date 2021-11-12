package com.abdigunawan.makeupme.ui.detail.testimoni

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.foodmarketkotlin.utils.Helpers.formatPrice
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.dummy.MuaTestimoniModel
import kotlinx.android.synthetic.main.item_paket_horizontal.view.*
import kotlinx.android.synthetic.main.item_testimoni_horizontal.view.*

class TestimoniMuaAdapter(
    private val listData: List<MuaTestimoniModel>,
    private val itemAdapterCallBack: ItemAdapterCallback,
) : RecyclerView.Adapter<TestimoniMuaAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimoniMuaAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_testimoni_horizontal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TestimoniMuaAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position],itemAdapterCallBack)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: MuaTestimoniModel, itemAdapterCallBack: ItemAdapterCallback) {
            itemView.apply {
                tvPelanggan.text = data.pelanggan
                tvKomentar.text = data.komentar

//                Glide.with(context)
//                    .load(data.src)
//                    .into(ivPoster)

                itemView.setOnClickListener { itemAdapterCallBack.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback{
        fun onClick(v: View, data: MuaTestimoniModel)
    }
}