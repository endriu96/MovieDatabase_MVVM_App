package com.endriu.tmdbclient.presentation.di

import com.endriu.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.endriu.tmdbclient.presentation.di.movie.MovieSubComponent
import com.endriu.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import com.endriu.tmdbclient.presentation.di.upcomingMovie.UpcomingMovieSubComponent

interface Injector {
   fun createMovieSubComponent(): MovieSubComponent
   fun createTvShowSubComponent(): TvShowSubComponent
   fun createArtistSubComponent(): ArtistSubComponent
   fun createUpcomingMovieSubComponent(): UpcomingMovieSubComponent
}