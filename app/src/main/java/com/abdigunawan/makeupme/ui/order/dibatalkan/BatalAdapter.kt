package com.abdigunawan.makeupme.ui.order.dibatalkan

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdigunawan.makeupme.BuildConfig
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.response.order.Transaksiuser
import com.abdigunawan.makeupme.utils.Helpers.formatPrice
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_inprogress.view.*
import java.text.SimpleDateFormat

class BatalAdapter(private val listData: List<Transaksiuser>,
                   private val itemAdapterCallback: ItemAdapterCallback
) :
    RecyclerView.Adapter<BatalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_inprogress, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data : Transaksiuser, itemAdapterCallback : ItemAdapterCallback) {
            itemView.apply {

                tvTitle.text = data.transaksiuser.user.name
                tvNamaPaket.text = data.transaksiuser.namaPaket
                tvTotal.formatPrice(data.totalHarga)
                tvJumlahOrang.text = data.jumlah + " Orang • "
                var formatDate = SimpleDateFormat("dd MMM yyyy, hh:mm")
                val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                val date = simpleDateFormat.parse(data.tanggalTransaksi)
                tvPrice2.text = formatDate.format(date)

                if (!data.transaksiuser.foto.isNullOrEmpty()) {
                    val profilMua = BuildConfig.BASE_URL + "assets/img/mua/paket/" + data.transaksiuser.foto
                    Glide.with(context)
                        .load(profilMua)
                        .into(ivPoster)
                }

                itemView.setOnClickListener { view -> itemAdapterCallback.onClick(view, data) }
            }
        }
    }

    interface ItemAdapterCallback {
        fun onClick(v: View?, data: Transaksiuser)
    }
}