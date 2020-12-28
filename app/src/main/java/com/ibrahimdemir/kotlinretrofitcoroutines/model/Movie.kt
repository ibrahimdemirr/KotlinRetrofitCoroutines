package com.ibrahimdemir.kotlinretrofitcoroutines.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("movie_count") val movie_count: Int?,
    @SerializedName("limit") val limit: Int?,
    @SerializedName("page_number") val page_number: Int?,
    @SerializedName("movies") val movies: List<MovieList>
)