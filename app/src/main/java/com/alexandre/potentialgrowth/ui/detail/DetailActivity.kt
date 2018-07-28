package com.alexandre.potentialgrowth.ui.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem
import com.alexandre.potentialgrowth.ui.home.knowledge.KnowledgeFragment
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailActivityViewModel

    public val VIEW_NAME_TYPE_IMAGE = "detail:type:image"

    public val VIEW_NAME_CONTAINER_BACKGROUND = "detail:container:backgound"

    public val VIEW_NAME_TEXT_TITLE = "detail:text:title"

    public val VIEW_NAME_TEXT_DESCRIPTION = "detail:text:description"

    public val VIEW_NAME_APPBARLAYOUT = "detail:nav:appbarlayout"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ViewCompat.setTransitionName(name, VIEW_NAME_TEXT_TITLE)
        ViewCompat.setTransitionName(description, VIEW_NAME_TEXT_DESCRIPTION)
        ViewCompat.setTransitionName(img, VIEW_NAME_TYPE_IMAGE)
        ViewCompat.setTransitionName(container, VIEW_NAME_CONTAINER_BACKGROUND)
        ViewCompat.setTransitionName(appBarLayout, VIEW_NAME_APPBARLAYOUT)

        val id = intent.getLongExtra(KnowledgeFragment().INTENT_DETAIL_EXTRA, 1)

        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactoryDetail(this, id))
                .get(DetailActivityViewModel::class.java)


        viewModel.learnItem.observe(this, Observer<LearnItem> {
            name.text = viewModel.learnItem.value?.name

            description.text = viewModel.learnItem.value?.description

            img.setImageDrawable(viewModel.learnItem.value?.getDrawable(img.context))

            viewModel.learnItem.value?.getColor(container.context)?.let {
                color ->
                container.setBackgroundColor(color)
                doneBtn.setTextColor(color)
            }

            viewModel.learnItem.value?.getTextColor(container.context)?.let {
                textColor ->
                name.setTextColor(textColor)
                description.setTextColor(textColor)
                congratulationTxt.setTextColor(textColor)
            }

            viewModel.learnItem.value?.getOppositeColor(container.context)?.let {
                color ->
                doneBtn.setBackgroundColor(color)
            }

            doneBtn.setOnClickListener({
                viewModel.insertContribution(viewModel.learnItem.value?.idLearnItem)
            })

        })

        viewModel.doneItNum.observe(this, Observer<Int> {
            if(it == 0){
                doneBtn.visibility = View.VISIBLE
                congratulationTxt.visibility = View.GONE
            }
            else
            {
                doneBtn.visibility = View.GONE
                congratulationTxt.visibility = View.VISIBLE
            }
        })
    }
}