package com.example.mvvm_master.RetrofitAPI

import com.example.mvvm_master.Model.UpcomingMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface  ApiService{

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(@Query("page") page : Int) : UpcomingMovieResponse


}