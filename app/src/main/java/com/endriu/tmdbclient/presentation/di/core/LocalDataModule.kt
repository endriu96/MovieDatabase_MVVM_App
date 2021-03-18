package com.endriu.tmdbclient.presentation.di.core

import com.endriu.tmdbclient.data.db.ArtistDao
import com.endriu.tmdbclient.data.db.MovieDao
import com.endriu.tmdbclient.data.db.TvShowDao
import com.endriu.tmdbclient.data.db.UpcomingMovieDao
import com.endriu.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.anushka.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.endriu.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.endriu.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.endriu.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.endriu.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieLocalDataSource
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasourceImpl.UpcomingMovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideUpcomingMovieLocalDataSource(upcomingMovieDao: UpcomingMovieDao): UpcomingMovieLocalDataSource {
        return UpcomingMovieLocalDataSourceImpl(upcomingMovieDao)
    }


}