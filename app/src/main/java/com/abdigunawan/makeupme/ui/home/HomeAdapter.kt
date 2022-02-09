package com.abdigunawan.makeupme.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.BuildConfig
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.dummy.HomeModel
import com.abdigunawan.makeupme.model.response.home.Kota
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_seeall_vertical.view.*

class HomeAdapter (
    private val listData : List<Kota>,
    private val itemAdapterCallBack : ItemAdapterCallback,
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_seeall_vertical, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position],itemAdapterCallBack)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data : Kota, itemAdapterCallBack: ItemAdapterCallback) {
            val profilMua = BuildConfig.BASE_URL+"assets/img/mua/" + data.gambar
            itemView.apply {
                tvTitle.text = data.name
                tvAlamat.text = data.alamat
//                Glide.with(context)
//                    .load(data.src)
//                    .into(ivPoster)
                Glide.with(context)
                    .load(profilMua)
                    .into(ivProfilMua)

                itemView.setOnClickListener { itemAdapterCallBack.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback{
        fun onClick(v: View, data: Kota)
    }
}