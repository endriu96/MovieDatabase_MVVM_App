package com.endriu.tmdbclient.data.model.movieUpcoming

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName="upcomingMovie")
data class UpcomingMovie(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val vote_average: Double
)