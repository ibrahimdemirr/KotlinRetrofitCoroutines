package com.ibrahimdemir.kotlinretrofitcoroutines.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimdemir.kotlinretrofitcoroutines.R
import com.ibrahimdemir.kotlinretrofitcoroutines.model.MovieList
import com.squareup.picasso.Picasso

class MoviesViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_movie, viewGroup, false)
) {

    val parentLayout by lazy { itemView.findViewById<LinearLayout>(R.id.parentLayout) }
    private val movieImage by lazy { itemView.findViewById<ImageView>(R.id.movieImage) }
    private val movieTitle by lazy { itemView.findViewById<TextView>(R.id.movieTitle) }
    private val movieYear by lazy { itemView.findViewById<TextView>(R.id.movieYear) }
    private val movieRating by lazy { itemView.findViewById<TextView>(R.id.movieRating) }
    private val movieSummary by lazy { itemView.findViewById<TextView>(R.id.movieSummary) }

    fun bindTo(movieList: List<MovieList>) {
        movieList.forEach {
            movieTitle.text = it.title
            movieYear.text = it.year
            movieRating.text = it.rating
            movieSummary.text = it.summary
            Picasso.with(itemView.context).load(it.large_cover_image).into(movieImage)
        }
    }
}