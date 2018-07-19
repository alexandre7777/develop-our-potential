package com.alexandre.potentialgrowth.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private val adapter = LearnItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the view model
        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(this))
                .get(MainActivityViewModel::class.java)

        initAdapter()
    }

    private fun initAdapter(){
        list.layoutManager = LinearLayoutManager(applicationContext)
        list.adapter = adapter

        viewModel.mLearnItem.observe(this, Observer<List<LearnItem>> {
            Log.d("Activity", "list: ${it?.size}")
            adapter.submitList(it)
        })
    }
}
