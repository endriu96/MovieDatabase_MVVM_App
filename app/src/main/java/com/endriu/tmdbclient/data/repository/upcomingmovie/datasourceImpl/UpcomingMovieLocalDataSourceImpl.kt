package com.endriu.tmdbclient.data.repository.upcomingmovie.datasourceImpl


import com.endriu.tmdbclient.data.db.UpcomingMovieDao

import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovie

import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpcomingMovieLocalDataSourceImpl(private val upcomingMovieDao: UpcomingMovieDao):
    UpcomingMovieLocalDataSource {
    override suspend fun getUpcomingMoviesFromDB(): List<UpcomingMovie> {
        return upcomingMovieDao.getUpcomingMovie()
    }

    override suspend fun saveUpcomingMoviesToDB(upcomingMovie: List<UpcomingMovie>) {
        /*
        When we are getting data from the room database, room execute that query in a back ground thread.
        So we don’t need to explicitly write codes for background processing. But, we need to invoke other dao
        functions from a background thread. We will use coroutines for that.
         */
        CoroutineScope(Dispatchers.IO).launch {
            upcomingMovieDao.saveUpcomingMovie(upcomingMovie)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            upcomingMovieDao.deleteAllUpcomingMovie()
        }
    }


}