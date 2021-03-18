package com.endriu.tmdbclient.domain.repository

import com.endriu.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}