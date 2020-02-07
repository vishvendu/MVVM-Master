package com.example.mvvm_master.DataSource

import androidx.paging.PageKeyedDataSource
import com.example.mvvm_master.Model.Result
import com.example.mvvm_master.Model.UpcomingMovieResponse
import com.example.mvvm_master.RetrofitAPI.MyRetrofitBuilder
import com.example.mvvm_master.Utils.Constants.INITIAL_PAGE_LOAD
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class UpcomingMovieDataSource() : PageKeyedDataSource<Int , Result>(){


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Result>
    ) {

        CoroutineScope(IO).launch {

            val response = MyRetrofitBuilder.apiService.getUpcomingMovie(INITIAL_PAGE_LOAD)
            callback.onResult(response.results,null, INITIAL_PAGE_LOAD+1)

        }

    }


    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Result>
    ) {


        CoroutineScope(IO).launch {

            val response = MyRetrofitBuilder.apiService.getUpcomingMovie(params.key)
            var key =   if (response.totalPages > response.page) params.key+1 else null
            callback.onResult(response.results,key)


        }

    }


    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Result>
    ) {

        CoroutineScope(IO).launch {

            val response = MyRetrofitBuilder.apiService.getUpcomingMovie(params.key)
            var key = if (params.key > 1) params.key -1 else null ;
            callback.onResult(response.results,key)


        }


    }


}