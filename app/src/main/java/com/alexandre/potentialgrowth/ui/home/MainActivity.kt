package com.alexandre.potentialgrowth.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alexandre.potentialgrowth.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
