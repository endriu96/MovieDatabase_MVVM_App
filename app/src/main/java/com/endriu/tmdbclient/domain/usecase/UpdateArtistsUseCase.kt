package com.endriu.tmdbclient.domain.usecase

import com.endriu.tmdbclient.data.model.artist.Artist
import com.endriu.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}