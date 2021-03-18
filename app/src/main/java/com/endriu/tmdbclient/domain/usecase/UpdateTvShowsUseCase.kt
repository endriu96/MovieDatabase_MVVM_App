package com.endriu.tmdbclient.domain.usecase

import com.endriu.tmdbclient.data.model.tvshow.TvShow
import com.endriu.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>?=tvShowRepository.updateTvShows()
}