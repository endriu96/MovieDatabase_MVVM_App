package com.endriu.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovie

//For comunication with Database
@Dao
interface UpcomingMovieDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUpcomingMovie(upcomingMovie: List<UpcomingMovie>)

    @Query("DELETE FROM upcomingMovie")
    suspend fun deleteAllUpcomingMovie()

    @Query("SELECT * FROM upcomingMovie")
    suspend fun getUpcomingMovie():List<UpcomingMovie>
}