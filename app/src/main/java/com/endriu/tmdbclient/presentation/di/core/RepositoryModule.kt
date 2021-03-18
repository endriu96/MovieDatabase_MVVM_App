package com.endriu.tmdbclient.presentation.di.core

import com.endriu.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.endriu.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.endriu.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.endriu.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.endriu.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.endriu.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.endriu.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.endriu.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.endriu.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.endriu.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.endriu.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.endriu.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.endriu.tmdbclient.data.repository.upcomingmovie.UpcomingMovieRepositoryImpl
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieCacheDataSource
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieLocalDataSource
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieRemoteDataSource
import com.endriu.tmdbclient.domain.repository.ArtistRepository
import com.endriu.tmdbclient.domain.repository.MovieRepository
import com.endriu.tmdbclient.domain.repository.TvShowRepository
import com.endriu.tmdbclient.domain.repository.UpcomingMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )


    }


    @Provides
    @Singleton
    fun provideUpcomingMovieRepository(
        upcomingMovieRemoteDatasource: UpcomingMovieRemoteDataSource,
        upcomingMovieLocalDataSource: UpcomingMovieLocalDataSource,
        upcomingMovieCacheDataSource: UpcomingMovieCacheDataSource
    ): UpcomingMovieRepository {


        return UpcomingMovieRepositoryImpl(
            upcomingMovieCacheDataSource,
            upcomingMovieLocalDataSource,
            upcomingMovieRemoteDatasource
        )


    }

}