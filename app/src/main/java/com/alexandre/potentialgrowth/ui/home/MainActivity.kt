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

        createFakeLearnItem()

        initAdapter()
    }

    private fun initAdapter(){
        list.layoutManager = LinearLayoutManager(applicationContext)
        list.adapter = adapter

        viewModel.mLearnItem.observe(this, Observer<List<LearnItem>> {
            Log.d("Activity", "list: ${it?.size}")
            //showEmptyList(it?.size == 0)
            adapter.submitList(it)
        })
    }

    private fun createFakeLearnItem() {
        val learnItem = LearnItem(1, "Make everyday matter", "Learn new a topic everyday, contribute to your Github everyday", "https://images.pexels.com/photos/888992/pexels-photo-888992.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")

        viewModel.addLearnItem(learnItem)

        val learnItem2 = LearnItem(2, "Calm your emotions", "description", "imgUrl")

        viewModel.addLearnItem(learnItem2)

        val learnItem3 = LearnItem(3, "Calm others people emotions", "description", "imgUrl")

        viewModel.addLearnItem(learnItem3)

        val learnItem4 = LearnItem(4, "Understand rather than be understood", "description", "imgUrl")

        viewModel.addLearnItem(learnItem4)

        val learnItem5 = LearnItem(5, "Made him understand that you understood it by reformulating", "description", "imgUrl")

        viewModel.addLearnItem(learnItem5)

        val learnItem6 = LearnItem(6, "Juxtapose your point of view to his rather than oppose it", "description", "imgUrl")

        viewModel.addLearnItem(learnItem6)

        val learnItem7 = LearnItem(7, "Propose a solution", "description", "imgUrl")

        viewModel.addLearnItem(learnItem7)
    }
}
