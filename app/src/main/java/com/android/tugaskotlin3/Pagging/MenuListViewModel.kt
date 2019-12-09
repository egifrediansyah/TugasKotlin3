package com.android.tugaskotlin3.Pagging

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.Pagging.NetworkService
import com.Pagging.State
import io.reactivex.disposables.CompositeDisposable

class MenuListViewModel : ViewModel(){
    private val networkService = NetworkService.getService()
    var newsList: LiveData<PagedList<Menu>>
    private val compositeDisposable = CompositeDisposable()
    private val pageSize = 1
    private val newsDataSourceFactory: MenuDataSourceFactory

    init {
        newsDataSourceFactory = MenuDataSourceFactory(
            compositeDisposable, networkService)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()
        newsList = LivePagedListBuilder(newsDataSourceFactory,
            config).build()
    }

    fun getState(): LiveData<State> = Transformations.switchMap<MenuDataSource,
            State>(newsDataSourceFactory.newsDataSourceLiveData, MenuDataSource::state)

    fun retry(){
        newsDataSourceFactory.newsDataSourceLiveData.value?.retry()
    }

    fun listIsEmpty(): Boolean{
        return newsList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}