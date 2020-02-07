package com.example.mvvm_master.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_master.Model.Result
import com.example.mvvm_master.R
import com.example.mvvm_master.Utils.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.upcomingmovie_items.view.*




class UpcomingMovieAdapter(private val context: UpcomingMovieActivity, var resultList: List<Result>) :
    RecyclerView.Adapter<UpcomingMovieAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.upcomingmovie_items,parent,false))

    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(resultList[position])

    }

    class ViewHolder(view : View): RecyclerView.ViewHolder(view) {

      //  val upcomingMovieName = view.upcomingmovieText
        val upcomingMovieBackdrop = view.upcomingmovieBackdrop

        fun bind(result: Result) {
            //upcomingMovieName?.text = result.title

            Picasso.get().load(Constants.BACKDROP_URL_W300+result.posterPath).into(upcomingMovieBackdrop)
        }

    }


}