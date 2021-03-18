package com.endriu.tmdbclient.data.model.movieUpcoming

import com.google.gson.annotations.SerializedName

data class UpcomingMovieList(

    @SerializedName("results")
    val upcomingMovies: List<UpcomingMovie>

)