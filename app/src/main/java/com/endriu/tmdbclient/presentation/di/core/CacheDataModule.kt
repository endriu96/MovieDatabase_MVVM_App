package com.endriu.tmdbclient.presentation.di.core

import com.endriu.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.anushka.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.endriu.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.endriu.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.endriu.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.endriu.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieCacheDataSource
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasourceImpl.UpcomingMovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }


    @Singleton
    @Provides
    fun provideUpcomingMovieCacheDataSource(): UpcomingMovieCacheDataSource {
        return UpcomingMovieCacheDataSourceImpl()
    }

}