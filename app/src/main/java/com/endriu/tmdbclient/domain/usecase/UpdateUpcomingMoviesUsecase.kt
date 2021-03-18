package com.endriu.tmdbclient.domain.usecase


import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovie

import com.endriu.tmdbclient.domain.repository.UpcomingMovieRepository

class UpdateUpcomingMoviesUsecase(private val upcomingMovie: UpcomingMovieRepository) {
    suspend fun execute():List<UpcomingMovie>? = upcomingMovie.updateUpcomingMovies()
}