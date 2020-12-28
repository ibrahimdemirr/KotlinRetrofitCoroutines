package com.ibrahimdemir.kotlinretrofitcoroutines.model

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("id") val id: Int?,
    @SerializedName("url") val url: String?,
    @SerializedName("imdb_code") val imdb_code: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("title_english") val title_english: String?,
    @SerializedName("title_long") val title_long: String?,
    @SerializedName("slug") val slug: String?,
    @SerializedName("year") val year: String?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("summary") val summary: String?,
    @SerializedName("large_cover_image") val large_cover_image: String?
)