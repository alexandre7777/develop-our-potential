package com.alexandre.potentialgrowth.ui.dashboarddetail

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem
import com.alexandre.potentialgrowth.ui.home.dashboard.DashBoardFragment
import com.alexandre.potentialgrowth.ui.home.knowledge.KnowledgeFragment
import kotlinx.android.synthetic.main.activity_dashbroad_detail.*

class DashboardDetailActivity : AppCompatActivity() {

    public val VIEW_PROGRESSION_PROGRESS = "detail:progression:progress"

    public val VIEW_NAME_APPBARLAYOUT = "detail:nav:appbarlayout"

    public val VIEW_IMG_PICTO = "detail:img:picto"

    public val VIEW_TXT_TITLE = "detail:text:title"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashbroad_detail)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ViewCompat.setTransitionName(progressBar, VIEW_PROGRESSION_PROGRESS)
        ViewCompat.setTransitionName(appBarLayout, VIEW_NAME_APPBARLAYOUT)
        ViewCompat.setTransitionName(imageView, VIEW_IMG_PICTO)
        ViewCompat.setTransitionName(titleTxt, VIEW_TXT_TITLE)

        val id = intent.getIntExtra(DashBoardFragment().INTENT_DETAIL_EXTRA, 1)

        val title = intent.getStringExtra(DashBoardFragment().INTENT_DETAIL_EXTRA_TEXT)

        val learnItem = LearnItem(0, id, 0, "", "", "")

        backgroundCL.setBackgroundColor(learnItem.getColor(this))

        progressBar.background = learnItem.getProgressDrawable(this)

        titleTxt.setTextColor(learnItem.getTextColor(this))
        titleTxt.text = title

        explanationTxt.setTextColor(learnItem.getTextColor(this))

        explanationTxt.text = getString(R.string.explanation, title)

        imageView.setImageDrawable(learnItem.getDrawable(this))
    }
}