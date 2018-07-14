package com.alexandre.potentialgrowth.ui.home

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the view model
        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(this))
                .get(MainActivityViewModel::class.java)

        //val learnItem = LearnItem(0, "name", "description", "imgUrl")

        //viewModel.addLearnItem(learnItem)

        //val learnItemResult = viewModel.getAllLearnItem()
    }
}
