package com.android.tugaskotlin3.Pagging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.Pagging.NetworkService
import io.reactivex.disposables.CompositeDisposable

class MenuDataSourceFactory (
    private val compositeDisposable: CompositeDisposable,
    private val networkService: NetworkService
)
    : DataSource.Factory<Int, Menu>(){

    val newsDataSourceLiveData = MutableLiveData<MenuDataSource>()

    override fun create() : DataSource<Int, Menu> {
        val newsDataSource = MenuDataSource(networkService, compositeDisposable)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}