package com.endriu.tmdbclient.data.repository.upcomingmovie.datasource

import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovie


interface UpcomingMovieLocalDataSource {

    suspend fun getUpcomingMoviesFromDB():List<UpcomingMovie>
    suspend fun saveUpcomingMoviesToDB(upcomingMovie: List<UpcomingMovie>)
    suspend fun clearAll()
}