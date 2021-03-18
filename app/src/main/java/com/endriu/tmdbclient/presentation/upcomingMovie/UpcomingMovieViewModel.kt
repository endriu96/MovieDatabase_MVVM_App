package com.endriu.tmdbclient.presentation.upcomingMovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.endriu.tmdbclient.domain.usecase.GetUpcomingMoviesUseCase
import com.endriu.tmdbclient.domain.usecase.UpdateUpcomingMoviesUsecase

class UpcomingMovieViewModel(
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val updateUpcomingMoviesUsecase: UpdateUpcomingMoviesUsecase
): ViewModel() {

    fun getUpcomingMovies() = liveData {
        val upcomingMovieList = getUpcomingMoviesUseCase.execute()
        emit(upcomingMovieList)
    }

    fun updateUpcomingMovies() = liveData {
        val upcomingMovieList = updateUpcomingMoviesUsecase.execute()
        emit(upcomingMovieList)
    }

    }





