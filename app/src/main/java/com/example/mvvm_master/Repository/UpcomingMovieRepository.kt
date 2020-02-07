package com.example.mvvm_master.Repository

import androidx.lifecycle.LiveData
import com.example.mvvm_master.Model.UpcomingMovieResponse
import com.example.mvvm_master.RetrofitAPI.MyRetrofitBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object UpcomingMovieRepository {



    fun getUpcomingMovieFromRetrofit(pageNo: Int) : LiveData<UpcomingMovieResponse>{

        return object : LiveData<UpcomingMovieResponse>(){
            override fun onActive() {
                super.onActive()

                CoroutineScope(IO).launch {
                    val upcomingMovieResponse = MyRetrofitBuilder.apiService.getUpcomingMovie(pageNo)
                    withContext(Main){
                        value = upcomingMovieResponse
                    }
                }
            }


        }
    }

}