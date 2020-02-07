package com.example.mvvm_master.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_master.Model.Result
import com.example.mvvm_master.Model.UpcomingMovieResponse
import com.example.mvvm_master.R
import com.example.mvvm_master.Utils.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.upcomingmovie_items.view.*

class UpcomingMoviePagedListAdapter :
    PagedListAdapter<Result, UpcomingMoviePagedListAdapter.MyViewHolder>((DiffUtilCallBack())) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviePagedListAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcomingmovie_items, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val upcomingMovieBackdrop = itemView.upcomingmovieBackdrop

        fun bindPost(result: Result) {
            //upcomingMovieName?.text = result.title

            Picasso.get().load(Constants.BACKDROP_URL_W300+result.posterPath).into(upcomingMovieBackdrop)
        }


    }

    override fun onBindViewHolder(holder: UpcomingMoviePagedListAdapter.MyViewHolder, position: Int) {

        //holder.bindPost(resultList[position])
        getItem(position)?.let {

            holder.bindPost(it) }
    }


}