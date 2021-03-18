package com.endriu.tmdbclient.domain.usecase

import com.endriu.tmdbclient.data.model.movie.Movie
import com.endriu.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}