package com.endriu.tmdbclient.data.repository.upcomingmovie

import android.util.Log
import com.endriu.tmdbclient.data.model.movieUpcoming.UpcomingMovie
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieCacheDataSource
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieLocalDataSource
import com.endriu.tmdbclient.data.repository.upcomingmovie.datasource.UpcomingMovieRemoteDataSource

import com.endriu.tmdbclient.domain.repository.UpcomingMovieRepository
import java.lang.Exception

class UpcomingMovieRepositoryImpl(
    private val upcomingMovieCacheDataSource: UpcomingMovieCacheDataSource,
    private val upcomingMovieLocalDataSource: UpcomingMovieLocalDataSource,
    private val upcomingMovieRemoteDataSource: UpcomingMovieRemoteDataSource

): UpcomingMovieRepository {
    override suspend fun getUpcomingMovies(): List<UpcomingMovie>? {
        return getUpcomingMoviesFromCache()
    }

    override suspend fun updateUpcomingMovies(): List<UpcomingMovie>? {
        val newListOfUpcomingMovies= getUpcomingMoviesFromAPI()
        upcomingMovieLocalDataSource.clearAll()
        upcomingMovieLocalDataSource.saveUpcomingMoviesToDB(newListOfUpcomingMovies)
        upcomingMovieCacheDataSource.saveUpcomingMoviesToCache(newListOfUpcomingMovies)
        return newListOfUpcomingMovies
    }

    suspend fun getUpcomingMoviesFromAPI(): List<UpcomingMovie>{
        lateinit var upcomingMovieList: List<UpcomingMovie>
        try {
            val response = upcomingMovieRemoteDataSource.getUpcomingMovies()
            val body = response.body()
            if(body!=null){
                upcomingMovieList = body.upcomingMovies
            }

        }catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return upcomingMovieList
    }


    suspend fun getUpcomingMoviesFromDB():List<UpcomingMovie>{
        lateinit var upcomingMovieList: List<UpcomingMovie>
        try {
            upcomingMovieList = upcomingMovieLocalDataSource.getUpcomingMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(upcomingMovieList.size>0){
            return upcomingMovieList
        }else{
            upcomingMovieList=getUpcomingMoviesFromAPI()
            upcomingMovieLocalDataSource.saveUpcomingMoviesToDB(upcomingMovieList)
        }

        return upcomingMovieList
    }

    suspend fun getUpcomingMoviesFromCache():List<UpcomingMovie>{
        lateinit var upcomingMovieList: List<UpcomingMovie>
        try {
            upcomingMovieList =upcomingMovieCacheDataSource.getUpcomingMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(upcomingMovieList.size>0){
            return upcomingMovieList
        }else{
            upcomingMovieList=getUpcomingMoviesFromDB()
            upcomingMovieCacheDataSource.saveUpcomingMoviesToCache(upcomingMovieList)
        }

        return upcomingMovieList
    }
}