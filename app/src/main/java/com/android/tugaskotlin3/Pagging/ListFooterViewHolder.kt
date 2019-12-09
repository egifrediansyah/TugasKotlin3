package com.Pagging

import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.tugaskotlin3.R
import kotlinx.android.synthetic.main.activity_news_list_pagging.view.*
import kotlinx.android.synthetic.main.activity_news_list_pagging.view.progress_bar
import kotlinx.android.synthetic.main.item_list_footer_pagging.view.*

class ListFooterViewHolder(view: View) : RecyclerView.ViewHolder(view){

    fun bind(status: State?) {
        itemView.progress_bar.visibility = if (status == State.LOADING) View.VISIBLE else View.INVISIBLE
        itemView.txt_action.visibility = if (status == State.ERROR) VISIBLE else View.INVISIBLE

    }
    companion object {
        fun create(retry: () -> Unit, parent: ViewGroup): ListFooterViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_footer_pagging, parent, false)
            view.txt_action.setOnClickListener { retry() }
            return ListFooterViewHolder(view)
        }

    }

}