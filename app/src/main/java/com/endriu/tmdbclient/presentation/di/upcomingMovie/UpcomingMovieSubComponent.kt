package com.endriu.tmdbclient.presentation.di.upcomingMovie

import com.endriu.tmdbclient.presentation.upcomingMovie.UpcomingMovieActivity
import dagger.Subcomponent

@UpcomingMovieScope
@Subcomponent(modules = [UpcomingMovieModule::class])
interface UpcomingMovieSubComponent {
    fun inject(upcomingMovieActivity: UpcomingMovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): UpcomingMovieSubComponent
    }

}

