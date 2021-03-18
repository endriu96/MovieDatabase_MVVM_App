package com.endriu.tmdbclient.data.repository.movie.datasource

import com.endriu.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
   suspend fun getMovies(): Response<MovieList>
}