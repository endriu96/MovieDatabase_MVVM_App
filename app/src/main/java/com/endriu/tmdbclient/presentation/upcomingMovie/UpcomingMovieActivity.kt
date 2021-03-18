package com.endriu.tmdbclient.presentation.upcomingMovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anushka.tmdbclient.R
import com.anushka.tmdbclient.databinding.ActivityUpcomingMovieBinding
import com.endriu.tmdbclient.presentation.di.Injector


import javax.inject.Inject

class UpcomingMovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: UpcomingMovieViewModelFactory
    private lateinit var upcomingMovieViewModel: UpcomingMovieViewModel
    private lateinit var binding: ActivityUpcomingMovieBinding
    private lateinit var adapter: UpcomingMovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_upcoming_movie)
        (application as Injector).createUpcomingMovieSubComponent()
            .inject(this)

        upcomingMovieViewModel=ViewModelProvider(this,factory)
            .get(UpcomingMovieViewModel::class.java)
        initRecyclerView()

    }

    private fun initRecyclerView(){
     binding.upcomingMovieRecyclerView.layoutManager = LinearLayoutManager(this)
     adapter = UpcomingMovieAdapter()
     binding.upcomingMovieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.upcomingMovieProgressBar.visibility = View.VISIBLE
        val responseLiveData = upcomingMovieViewModel.getUpcomingMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
             adapter.setList(it)
             adapter.notifyDataSetChanged()
             binding.upcomingMovieProgressBar.visibility = View.GONE
            }else{
                binding.upcomingMovieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateMovies(){
      binding.upcomingMovieProgressBar.visibility = View.VISIBLE
      val response = upcomingMovieViewModel.updateUpcomingMovies()
      response.observe(this, Observer {
        if(it!=null){
          adapter.setList(it)
          adapter.notifyDataSetChanged()
          binding.upcomingMovieProgressBar.visibility = View.GONE
        }else{
          binding.upcomingMovieProgressBar.visibility = View.GONE
        }
      })
    }





}