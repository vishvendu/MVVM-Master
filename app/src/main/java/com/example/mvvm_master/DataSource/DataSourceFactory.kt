package com.example.mvvm_master.DataSource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.mvvm_master.Model.Result
import android.content.ClipData.Item
import androidx.paging.PageKeyedDataSource





class DataSourceFactory :
    DataSource.Factory<Int, Result>() {


    private val itemLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Result>>()


    private val mutableLiveData: MutableLiveData<UpcomingMovieDataSource>? = null
    private val upcomingMovieDataSource: UpcomingMovieDataSource? = null


    override fun create(): DataSource<Int, Result> {


        val obj = UpcomingMovieDataSource()

        itemLiveDataSource.postValue(obj)

        return obj
    }

    fun getItemLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, Result>> {
        return itemLiveDataSource
    }

}