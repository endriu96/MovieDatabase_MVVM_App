package com.endriu.tmdbclient.presentation.di.movie

import com.endriu.tmdbclient.domain.usecase.GetMoviesUseCase
import com.endriu.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.endriu.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}