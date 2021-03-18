package com.endriu.tmdbclient.domain.usecase

import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovie
import com.endriu.tmdbclient.domain.repository.UpcomingMovieRepository

class GetUpcomingMoviesUseCase(private val upcomingMovieRepository: UpcomingMovieRepository) {
  suspend fun execute():List<UpcomingMovie>? = upcomingMovieRepository.getUpcomingMovies()

}