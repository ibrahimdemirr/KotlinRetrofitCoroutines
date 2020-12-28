package com.ibrahimdemir.kotlinretrofitcoroutines.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("status") val status: String?,
    @SerializedName("status_message") val status_message: String?,
    @SerializedName("data") val movie: Movie?
)