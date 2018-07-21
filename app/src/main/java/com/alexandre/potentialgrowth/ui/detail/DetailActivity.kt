package com.alexandre.potentialgrowth.ui.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getLongExtra("intentdetailextrakey", 1)

        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactoryDetail(this, id))
                .get(DetailActivityViewModel::class.java)


        viewModel.learnItem.observe(this, Observer<LearnItem> {
            name.text = viewModel.learnItem.value?.name

            description.text = viewModel.learnItem.value?.description

            Glide.with(this).load(viewModel.learnItem.value?.imgUrl).into(img)

        })
    }
}