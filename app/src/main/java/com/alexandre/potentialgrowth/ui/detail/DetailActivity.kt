package com.alexandre.potentialgrowth.ui.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailActivityViewModel

    public val VIEW_NAME_TYPE_IMAGE = "detail:type:image"

    public val VIEW_NAME_CONTAINER_BACKGROUND = "detail:container:backgound"

    public val VIEW_NAME_TEXT_TITLE = "detail:text:title"

    public val VIEW_NAME_TEXT_DESCRIPTION = "detail:text:description"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        ViewCompat.setTransitionName(name, VIEW_NAME_TEXT_TITLE)
        ViewCompat.setTransitionName(description, VIEW_NAME_TEXT_DESCRIPTION)
        ViewCompat.setTransitionName(img, VIEW_NAME_TYPE_IMAGE)
        ViewCompat.setTransitionName(container, VIEW_NAME_CONTAINER_BACKGROUND)

        val id = intent.getLongExtra("intentdetailextrakey", 1)

        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactoryDetail(this, id))
                .get(DetailActivityViewModel::class.java)


        viewModel.learnItem.observe(this, Observer<LearnItem> {
            name.text = viewModel.learnItem.value?.name

            description.text = viewModel.learnItem.value?.description

            when (viewModel.learnItem.value?.idType){
                1 -> {
                    container.setBackgroundColor(ContextCompat.getColor(container.context, R.color.communication))
                    img.setImageDrawable(ContextCompat.getDrawable(img.context, R.drawable.people))
                    name.setTextColor(ContextCompat.getColor(container.context, R.color.white))
                    description.setTextColor(ContextCompat.getColor(container.context, R.color.white))
                }
                2 -> {
                    container.setBackgroundColor(ContextCompat.getColor(container.context, R.color.life_style))
                    img.setImageDrawable(ContextCompat.getDrawable(img.context, R.drawable.thumb_up))
                    name.setTextColor(ContextCompat.getColor(container.context, R.color.white))
                    description.setTextColor(ContextCompat.getColor(container.context, R.color.white))
                }
                3 -> {
                    container.setBackgroundColor(ContextCompat.getColor(container.context, R.color.self_confidence))
                    img.setImageDrawable(ContextCompat.getDrawable(img.context, R.drawable.smile))
                    name.setTextColor(ContextCompat.getColor(container.context, R.color.black))
                    description.setTextColor(ContextCompat.getColor(container.context, R.color.black))
                }
                4 -> {
                    container.setBackgroundColor(ContextCompat.getColor(container.context, R.color.health))
                    img.setImageDrawable(ContextCompat.getDrawable(img.context, R.drawable.heart))
                    name.setTextColor(ContextCompat.getColor(container.context, R.color.black))
                    description.setTextColor(ContextCompat.getColor(container.context, R.color.black))
                }
                5 -> {
                    container.setBackgroundColor(ContextCompat.getColor(container.context, R.color.white))
                    img.setImageDrawable(ContextCompat.getDrawable(img.context, R.drawable.cake))
                    name.setTextColor(ContextCompat.getColor(container.context, R.color.black))
                    description.setTextColor(ContextCompat.getColor(container.context, R.color.black))
                }
            }

        })
    }
}