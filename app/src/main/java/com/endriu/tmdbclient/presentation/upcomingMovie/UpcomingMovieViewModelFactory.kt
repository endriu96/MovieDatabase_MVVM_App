package com.endriu.tmdbclient.presentation.upcomingMovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.endriu.tmdbclient.domain.usecase.GetUpcomingMoviesUseCase

import com.endriu.tmdbclient.domain.usecase.UpdateUpcomingMoviesUsecase


class UpcomingMovieViewModelFactory(
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val updateUpcomingMoviesUsecase: UpdateUpcomingMoviesUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UpcomingMovieViewModel(getUpcomingMoviesUseCase,updateUpcomingMoviesUsecase) as T
    }
}

