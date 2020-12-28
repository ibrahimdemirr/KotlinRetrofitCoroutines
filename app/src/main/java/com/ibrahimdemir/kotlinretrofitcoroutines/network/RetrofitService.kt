package com.ibrahimdemir.kotlinretrofitcoroutines.network

import com.ibrahimdemir.kotlinretrofitcoroutines.model.MovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("list_movies.json?sort_by=date_added")
    fun getLastMovies(): Deferred<Response<MovieResponse?>>
}