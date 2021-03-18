package com.endriu.tmdbclient.presentation.di.core

import com.endriu.tmdbclient.domain.repository.ArtistRepository
import com.endriu.tmdbclient.domain.repository.MovieRepository
import com.endriu.tmdbclient.domain.repository.TvShowRepository
import com.endriu.tmdbclient.domain.repository.UpcomingMovieRepository
import com.endriu.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpcomingGetMovieUseCase(upcomingMovieRepository: UpcomingMovieRepository): GetUpcomingMoviesUseCase {
        return GetUpcomingMoviesUseCase(upcomingMovieRepository)
    }
    @Provides
    fun provideUpcomingUpdateMovieUseCase(upcomingMovieRepository: UpcomingMovieRepository): UpdateUpcomingMoviesUsecase {
        return UpdateUpcomingMoviesUsecase(upcomingMovieRepository)
    }

}