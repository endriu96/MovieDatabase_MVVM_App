package com.endriu.tmdbclient.presentation.di.upcomingMovie

import com.endriu.tmdbclient.presentation.upcomingMovie.UpcomingMovieViewModelFactory
import com.endriu.tmdbclient.domain.usecase.GetUpcomingMoviesUseCase
import com.endriu.tmdbclient.domain.usecase.UpdateUpcomingMoviesUsecase
import dagger.Module
import dagger.Provides

@Module
class UpcomingMovieModule {
    @UpcomingMovieScope
    @Provides
    fun provideUpcomingMovieViewModelFactory(
        getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
        updateUpcomingMoviesUsecase: UpdateUpcomingMoviesUsecase
    ): UpcomingMovieViewModelFactory {
        return UpcomingMovieViewModelFactory(
            getUpcomingMoviesUseCase,
            updateUpcomingMoviesUsecase
        )
    }

}