package com.endriu.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.endriu.tmdbclient.data.model.artist.Artist
import com.endriu.tmdbclient.data.model.movie.Movie
import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovie
import com.endriu.tmdbclient.data.model.tvshow.TvShow


@Database(entities = [Movie::class, TvShow::class, Artist::class, UpcomingMovie::class],
version = 1,
exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase(){
abstract fun movieDao(): MovieDao
abstract fun tvDao(): TvShowDao
abstract fun artistDao(): ArtistDao
abstract fun upcomingMovieDao() : UpcomingMovieDao

}