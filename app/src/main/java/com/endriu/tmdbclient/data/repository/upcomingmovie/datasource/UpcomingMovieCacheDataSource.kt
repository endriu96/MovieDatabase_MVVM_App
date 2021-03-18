package com.endriu.tmdbclient.data.repository.upcomingmovie.datasource

import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovie


interface UpcomingMovieCacheDataSource {

    suspend fun getUpcomingMoviesFromCache():List<UpcomingMovie>
    suspend fun saveUpcomingMoviesToCache(upcomingMovie:List<UpcomingMovie>)
}