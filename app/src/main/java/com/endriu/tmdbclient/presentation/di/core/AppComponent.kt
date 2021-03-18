package com.endriu.tmdbclient.presentation.di.core

import com.endriu.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.endriu.tmdbclient.presentation.di.movie.MovieSubComponent
import com.endriu.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import com.endriu.tmdbclient.presentation.di.upcomingMovie.UpcomingMovieSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
DataBaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class
])
interface AppComponent {

fun movieSubComponent(): MovieSubComponent.Factory
fun tvShowSubComponent(): TvShowSubComponent.Factory
fun artistSubComponent(): ArtistSubComponent.Factory
fun upcomingMovieSubComponent(): UpcomingMovieSubComponent.Factory

}