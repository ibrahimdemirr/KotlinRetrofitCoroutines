package com.ibrahimdemir.kotlinretrofitcoroutines.adapters

import android.app.Activity
import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimdemir.kotlinretrofitcoroutines.ui.DetailActivity
import com.ibrahimdemir.kotlinretrofitcoroutines.holders.MoviesViewHolder
import com.ibrahimdemir.kotlinretrofitcoroutines.model.MovieResponse

class MoviesAdapter(private val movieResponse: MovieResponse, private val activity: Activity) :
    RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movieList = movieResponse.movie?.movies
        if (movieList != null) {
            holder.bindTo((listOf(movieList[position])))
        }

        holder.parentLayout.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("url", movieList?.get(position)?.url)
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movieResponse.movie?.movies?.size ?: 0
    }
}