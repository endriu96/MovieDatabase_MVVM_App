package com.endriu.tmdbclient.data.repository.upcomingmovie.datasource


import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovieList
import retrofit2.Response

interface UpcomingMovieRemoteDataSource {

    suspend fun getUpcomingMovies(): Response<UpcomingMovieList>
}