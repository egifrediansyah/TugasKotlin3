package com.android.tugaskotlin3.Pagging

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Pagging.State
import com.android.tugaskotlin3.R
import kotlinx.android.synthetic.main.activity_news_list_pagging.*

class MenuListActivity : AppCompatActivity(){
    private lateinit var viewModel: MenuListViewModel
    private lateinit var newsListAdapter: MenuListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list_pagging)

        viewModel = ViewModelProviders.of(this)
            .get(MenuListViewModel::class.java)
        initAdapter()
        initState()
    }

    private fun initAdapter(){
        newsListAdapter = MenuListAdapter { viewModel.retry() }
        recycler_view.layoutManager = GridLayoutManager(this,3)
        recycler_view.adapter = newsListAdapter
        viewModel.newsList.observe(this, Observer {
            newsListAdapter.submitList(it)
        })
    }

    private fun initState(){
        txt_error.setOnClickListener { viewModel.retry() }
        viewModel.getState().observe(this, Observer { state ->
            progress_bar.visibility = if (viewModel.listIsEmpty()
                && state == State.LOADING) View.VISIBLE else View.GONE
            txt_error.visibility = if (viewModel.listIsEmpty()
                && state == State.ERROR) View.VISIBLE else View.GONE
            if (!viewModel.listIsEmpty()){
                newsListAdapter.setState(state ?: State.DONE)
            }})
    }
}