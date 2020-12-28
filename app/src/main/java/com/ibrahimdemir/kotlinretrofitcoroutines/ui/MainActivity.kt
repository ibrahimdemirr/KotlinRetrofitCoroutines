package com.ibrahimdemir.kotlinretrofitcoroutines.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimdemir.kotlinretrofitcoroutines.R
import com.ibrahimdemir.kotlinretrofitcoroutines.adapters.MoviesAdapter
import com.ibrahimdemir.kotlinretrofitcoroutines.network.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var moviesRecyclerView: RecyclerView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesRecyclerView = findViewById(R.id.moviesRecyclerView)
        progressBar = findViewById(R.id.progressBar)

        progressBar?.visibility = View.VISIBLE

        GlobalScope.launch(Dispatchers.Main) {
            val service = RetrofitFactory.makeRetrofitService()
            val lastMovies = service.getLastMovies().await()

            if (lastMovies.isSuccessful) {
                moviesRecyclerView?.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = MoviesAdapter(lastMovies.body()!!, this@MainActivity)
                    visibility = View.VISIBLE
                }
            }
            progressBar?.visibility = View.GONE
        }
    }
}