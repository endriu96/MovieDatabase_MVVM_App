package com.endriu.tmdbclient.presentation

import android.app.Application
import com.anushka.tmdbclient.BuildConfig
import com.endriu.tmdbclient.presentation.di.Injector
import com.endriu.tmdbclient.presentation.di.artist.ArtistSubComponent

import com.endriu.tmdbclient.presentation.di.core.*
import com.endriu.tmdbclient.presentation.di.movie.MovieSubComponent
import com.endriu.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import com.endriu.tmdbclient.presentation.di.upcomingMovie.UpcomingMovieSubComponent

class App : Application(), Injector {
private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
       return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createUpcomingMovieSubComponent(): UpcomingMovieSubComponent {
        return appComponent.upcomingMovieSubComponent().create()
    }

}