package com.ibrahimdemir.kotlinretrofitcoroutines.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.ibrahimdemir.kotlinretrofitcoroutines.R

class DetailActivity : AppCompatActivity() {

    private var url: String? = null
    private var webView: WebView? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        webView = findViewById(R.id.webView)

        url = intent.getStringExtra("url")

        webView?.settings?.javaScriptEnabled = true
        webView?.loadUrl(url ?: "")
    }
}