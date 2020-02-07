package com.example.mvvm_master.View

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_master.R
import com.example.mvvm_master.ViewModel.UpcomingMovieViewModel
import com.example.mvvm_master.ViewModel.UpcomingMovieViewModelPaging
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class UpcomingMovieActivity : AppCompatActivity() {


    lateinit var viewModel : UpcomingMovieViewModel

    lateinit var viewModelPaging: UpcomingMovieViewModelPaging

    var upcomingMovieAdapter : UpcomingMovieAdapter? = null

    var upcomingMoviePagedListAdapter : UpcomingMoviePagedListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Picasso.get().setLoggingEnabled(true)

         upcomingMoviePagedListAdapter = UpcomingMoviePagedListAdapter()

      //  viewModel = ViewModelProvider(this).get(UpcomingMovieViewModel::class.java)

        viewModelPaging = ViewModelProvider(this).get(UpcomingMovieViewModelPaging::class.java)

        viewModelPaging.UpcomingMovieViewModelPaging()

        viewModelPaging.itemPagedList?.observe(this , Observer{


            upcomingMoviePagedListAdapter?.submitList(it)

        })

        recylcerViewUpcomingMovie!!.setLayoutManager(LinearLayoutManager(this,RecyclerView.HORIZONTAL,false))
        recylcerViewUpcomingMovie.adapter = upcomingMoviePagedListAdapter




       /* viewModel.upcomingMovieFromRespo.observe(this, Observer{
            println("DEBUG: ${it}")
            upcomingMovieAdapter = UpcomingMovieAdapter(this , it.results)
            recylcerViewUpcomingMovie!!.setLayoutManager(LinearLayoutManager(this,RecyclerView.HORIZONTAL,false))
            recylcerViewUpcomingMovie.adapter = upcomingMovieAdapter
            upcomingMovieAdapter?.notifyDataSetChanged()

        })*/


       // viewModel.setPageNo(1)



    }
}
