package com.endriu.tmdbclient.data.repository.upcomingmovie.datasourceImpl

import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovie
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieCacheDataSource
import java.util.ArrayList



class UpcomingMovieCacheDataSourceImpl: UpcomingMovieCacheDataSource {

    private var upcomingMovieList=ArrayList<UpcomingMovie>()

    override suspend fun getUpcomingMoviesFromCache(): List<UpcomingMovie> {
       return upcomingMovieList
    }

    override suspend fun saveUpcomingMoviesToCache(upcomingMovie: List<UpcomingMovie>) {
        //We need to convert this list to an ArrayList
        upcomingMovieList.clear()
        upcomingMovieList=ArrayList(upcomingMovieList)
    }
}