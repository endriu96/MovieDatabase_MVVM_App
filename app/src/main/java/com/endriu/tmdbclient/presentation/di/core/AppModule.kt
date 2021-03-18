package com.endriu.tmdbclient.presentation.di.core

import android.content.Context
import com.endriu.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.endriu.tmdbclient.presentation.di.movie.MovieSubComponent
import com.endriu.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import com.endriu.tmdbclient.presentation.di.upcomingMovie.UpcomingMovieSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class, UpcomingMovieSubComponent::class])
class AppModule(private val context: Context) {

 @Singleton
 @Provides
 fun provideApplicationContext():Context{
     return context.applicationContext
 }





}