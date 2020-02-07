package com.example.mvvm_master.RetrofitAPI

import com.example.mvvm_master.BuildConfig.TMDB_API_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofitBuilder {


    const val BASE_URL = "https://api.themoviedb.org/3/"

    val interceptor = Interceptor { chain ->
        val url = chain.request().url().newBuilder().addQueryParameter("api_key", TMDB_API_KEY).addQueryParameter("language" ,"en-US").build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        chain.proceed(request)
    }
    // we are creating a networking client using OkHttp and add our authInterceptor.
    val apiClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()


    val apiService : ApiService by lazy {

        retrofitBuilder
            .build().create(ApiService::class.java)

    }


    val retrofitBuilder : Retrofit.Builder by lazy{

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(apiClient)
            .addConverterFactory(GsonConverterFactory.create())

    }

}