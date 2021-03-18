package com.endriu.tmdbclient.presentation.di.core

import com.endriu.tmdbclient.data.api.TMDBService
import com.endriu.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.anushka.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.endriu.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.endriu.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.endriu.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.endriu.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieRemoteDataSource
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasourceImpl.UpcomingMovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideUpcomingMovieRemoteDataSource(tmdbService: TMDBService): UpcomingMovieRemoteDataSource {
        return UpcomingMovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }


}