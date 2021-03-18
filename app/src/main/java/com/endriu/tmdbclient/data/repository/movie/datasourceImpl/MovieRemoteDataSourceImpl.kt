package com.endriu.tmdbclient.data.repository.movie.datasourceImpl

import com.endriu.tmdbclient.data.api.TMDBService
import com.endriu.tmdbclient.data.model.movie.MovieList
import com.endriu.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}

