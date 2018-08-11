package com.alexandre.potentialgrowth.ui.dashboarddetail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem
import com.alexandre.potentialgrowth.ui.home.dashboard.DashBoardFragment
import kotlinx.android.synthetic.main.activity_dashbroad_detail.*

/**
 * Display one item for dashboard
 */
class DashboardDetailActivity : AppCompatActivity() {

    private lateinit var viewModelDashboardDetail: DashboardDetailViewModel

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

        viewModelDashboardDetail = ViewModelProviders.of(this, Injection.provideViewModelFactoryDashboardDetail(this, id))
                .get(DashboardDetailViewModel::class.java)

        viewModelDashboardDetail.countContribution.observe(this, Observer<Int> {
            val progress = it?.times(20) as Int
            progressBar.progress = progress
        })


        val title: String? = intent.getStringExtra(DashBoardFragment().INTENT_DETAIL_EXTRA_TEXT)


        setupView(id, title)
    }

    /**
     * Setup view colors, texts
     */
    private fun setupView(type : Int, title : String?) {
        val learnItem = LearnItem(0, type, 0, "", "", "")

        backgroundCL.setBackgroundColor(learnItem.getColor(this))

        progressBar.progressDrawable = learnItem.getProgressDrawable(this)

        titleTxt.setTextColor(learnItem.getTextColor(this))
        titleTxt.text = title

        explanationTxt.setTextColor(learnItem.getTextColor(this))

        explanationTxt.text = getString(R.string.explanation, title)

        imageView.setImageDrawable(learnItem.getDrawable(this))
    }
}