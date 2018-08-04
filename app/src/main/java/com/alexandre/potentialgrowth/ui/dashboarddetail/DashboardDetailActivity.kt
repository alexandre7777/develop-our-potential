package com.alexandre.potentialgrowth.ui.dashboarddetail

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import com.alexandre.potentialgrowth.R
import kotlinx.android.synthetic.main.activity_dashbroad_detail.*

class DashboardDetailActivity : AppCompatActivity() {

    public val VIEW_PROGRESSION_PROGRESS = "detail:progression:progress"

    public val VIEW_NAME_APPBARLAYOUT = "detail:nav:appbarlayout"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashbroad_detail)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ViewCompat.setTransitionName(progressBar, VIEW_PROGRESSION_PROGRESS)

        ViewCompat.setTransitionName(appBarLayout, VIEW_NAME_APPBARLAYOUT)
    }
}