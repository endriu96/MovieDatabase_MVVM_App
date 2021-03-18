package com.endriu.tmdbclient.presentation.di.artist

import com.endriu.tmdbclient.domain.usecase.GetArtistsUseCase
import com.endriu.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.endriu.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}