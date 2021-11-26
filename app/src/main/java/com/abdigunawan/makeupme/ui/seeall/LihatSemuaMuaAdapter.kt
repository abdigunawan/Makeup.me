package com.abdigunawan.makeupme.ui.seeall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.dummy.HomeModel
import kotlinx.android.synthetic.main.item_seeall_vertical.view.rbMua
import kotlinx.android.synthetic.main.item_seeall_vertical.view.tvAlamat
import kotlinx.android.synthetic.main.item_seeall_vertical.view.tvTitle

class LihatSemuaMuaAdapter(
    private val listData: List<HomeModel>,
    private val itemAdapterCallBack: LihatSemuaMuaActivity,
) : RecyclerView.Adapter<LihatSemuaMuaAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LihatSemuaMuaAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_seeall_vertical, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LihatSemuaMuaAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position],itemAdapterCallBack)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: HomeModel, itemAdapterCallBack: LihatSemuaMuaActivity) {
            itemView.apply {
                tvTitle.text = data.title
                tvAlamat.text = data.title
                rbMua.rating = data.rating

//                Glide.with(context)
//                    .load(data.src)
//                    .into(ivPoster)

                itemView.setOnClickListener { itemAdapterCallBack.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback{
        fun onClick(v: View, data: HomeModel)
    }
}