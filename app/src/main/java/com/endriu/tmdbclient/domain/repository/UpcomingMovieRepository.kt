package com.endriu.tmdbclient.domain.repository

import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovie

interface UpcomingMovieRepository {

    suspend fun getUpcomingMovies():List<UpcomingMovie>?
    suspend fun updateUpcomingMovies():List<UpcomingMovie>?

}