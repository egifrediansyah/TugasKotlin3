package com.android.tugaskotlin3.Pagging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.tugaskotlin3.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news_pagging.view.*

class MenuViewHolder(view: View)  : RecyclerView.ViewHolder(view) {
    fun bind(menu: Menu?){
        if (menu != null){
            itemView.tx_nama_produk.text = menu.name_product
            itemView.tx_harga_produk.text ="Rp "+ menu.price
            Picasso.get().load(menu.images).into(itemView.img_new)
        }
    }

    companion object{
        fun create(parent: ViewGroup): MenuViewHolder{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news_pagging, parent, false)
            return MenuViewHolder(view)
        }
    }
}