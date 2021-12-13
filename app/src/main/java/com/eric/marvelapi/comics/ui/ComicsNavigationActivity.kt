package com.eric.marvelapi.comics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eric.marvelapi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics_navigation)
    }
}