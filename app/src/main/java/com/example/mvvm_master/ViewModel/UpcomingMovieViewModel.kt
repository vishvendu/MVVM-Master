package com.example.mvvm_master.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.mvvm_master.Model.Result
import com.example.mvvm_master.Model.UpcomingMovieResponse
import com.example.mvvm_master.Repository.UpcomingMovieRepository

class UpcomingMovieViewModel : ViewModel() {

    private val _pageNo : MutableLiveData<Int> = MutableLiveData()

    val upcomingMovieFromRespo : LiveData<UpcomingMovieResponse> =
            Transformations
            .switchMap(_pageNo){pageNO ->
                UpcomingMovieRepository.getUpcomingMovieFromRetrofit(pageNO)
    }

    fun setPageNo(pageNo : Int){
        val update = pageNo
        if(_pageNo.value == update){
            return
        }
        _pageNo.value = update

    }
}