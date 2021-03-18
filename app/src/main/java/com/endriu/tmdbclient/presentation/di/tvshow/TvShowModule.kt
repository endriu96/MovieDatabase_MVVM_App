package com.endriu.tmdbclient.presentation.di.tvshow

import com.endriu.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.endriu.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.endriu.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}