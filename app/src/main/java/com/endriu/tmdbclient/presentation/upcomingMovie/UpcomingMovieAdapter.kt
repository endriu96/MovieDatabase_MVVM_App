package com.endriu.tmdbclient.presentation.upcomingMovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.anushka.tmdbclient.R

import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovie
import com.anushka.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide


class UpcomingMovieAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val upcomingMovieList = ArrayList<UpcomingMovie>()

    fun setList(upcomingMovies:List<UpcomingMovie>){
         upcomingMovieList.clear()
         upcomingMovieList.addAll(upcomingMovies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return upcomingMovieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(upcomingMovieList[position])
    }
}



class MyViewHolder(val binding: ListItemBinding):
RecyclerView.ViewHolder(binding.root){

   fun bind(upcomingMovie: UpcomingMovie){
        binding.titleTextView.text = upcomingMovie.title
        binding.descriptionTextView.text = upcomingMovie.overview
        val posterURL = "https://image.tmdb.org/t/p/w500"+upcomingMovie.poster_path
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

   }

}