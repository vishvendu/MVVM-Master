package com.example.mvvm_master.ViewModel

import androidx.lifecycle.ViewModel
import androidx.paging.PageKeyedDataSource
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.mvvm_master.DataSource.DataSourceFactory

import com.example.mvvm_master.Model.Result
import androidx.paging.LivePagedListBuilder

class UpcomingMovieViewModelPaging : ViewModel() {

    //creating livedata for PagedList  and PagedKeyedDataSource
    var itemPagedList: LiveData<PagedList<Result>>? = null
    var liveDataSource: LiveData<PageKeyedDataSource<Int, Result>>? = null



    fun UpcomingMovieViewModelPaging() {

        val DataFactory = DataSourceFactory()

        liveDataSource = DataFactory.getItemLiveDataSource()

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(33).build()


        itemPagedList = LivePagedListBuilder(DataFactory, pagedListConfig)
            .build()

    }

}