package com.endriu.tmdbclient.data.repository.upcomingmovie.datasourceImpl

import com.endriu.tmdbclient.data.api.TMDBService

import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovieList

import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieRemoteDataSource
import retrofit2.Response

class UpcomingMovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): UpcomingMovieRemoteDataSource {
    override suspend fun getUpcomingMovies(): Response<UpcomingMovieList> = tmdbService.getUpcomingMovies(apiKey)



}