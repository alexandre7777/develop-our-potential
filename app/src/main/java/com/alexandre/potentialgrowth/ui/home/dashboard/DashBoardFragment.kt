package com.alexandre.potentialgrowth.ui.home.dashboard

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexandre.potentialgrowth.Injection
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.ui.dashboarddetail.DashboardDetailActivity
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashBoardFragment : Fragment(){

    private lateinit var viewModelDashboard: DashBoardFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModelDashboard = ViewModelProviders.of(this, Injection.provideViewModelFactoryDashboard(activity!!))
                .get(DashBoardFragmentViewModel::class.java)

        viewModelDashboard.countContributionCommunication.observe(this, Observer<Int> {
            val progress = it?.times(20) as Int
            progressBarCommunication.setProgress(progress)
        })

        viewModelDashboard.countContributionLifeStyle.observe(this, Observer<Int> {
            val progress = it?.times(20) as Int
            progressBarLifeStyle.setProgress(progress)
        })

        viewModelDashboard.countContributionHealth.observe(this, Observer<Int> {
            val progress = it?.times(20) as Int
            progressBarHealth.setProgress(progress)
        })

        viewModelDashboard.countContributionSelfEsteem.observe(this, Observer<Int> {
            val progress = it?.times(20) as Int
            progressBarSelfConfidence.setProgress(progress)
        })

        viewModelDashboard.countContributionFindYourself.observe(this, Observer<Int> {
            val progress = it?.times(20) as Int
            progressBarFindYourself.setProgress(progress)
        })

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
    }

    private fun initListener() {

        lifeStyleCL.setOnClickListener() {
            val intent = Intent(activity, DashboardDetailActivity::class.java).apply {
                //putExtra(INTENT_DETAIL_EXTRA, learnItem.idLearnItem)
            }

            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity as Activity,

                    Pair<View, String>(view?.findViewById(R.id.progressBarLifeStyle),
                            DashboardDetailActivity().VIEW_PROGRESSION_PROGRESS),
                    Pair<View, String>(activity?.findViewById(R.id.appBarLayout),
                            DashboardDetailActivity().VIEW_NAME_APPBARLAYOUT))

            ActivityCompat.startActivity(activity as Activity, intent, activityOptions.toBundle())
        }

        communicationCL.setOnClickListener() {
            val intent = Intent(activity, DashboardDetailActivity::class.java).apply {
                //putExtra(INTENT_DETAIL_EXTRA, learnItem.idLearnItem)
            }

            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity as Activity,

                    Pair<View, String>(view?.findViewById(R.id.progressBarCommunication),
                            DashboardDetailActivity().VIEW_PROGRESSION_PROGRESS),
                    Pair<View, String>(activity?.findViewById(R.id.appBarLayout),
                            DashboardDetailActivity().VIEW_NAME_APPBARLAYOUT))

            ActivityCompat.startActivity(activity as Activity, intent, activityOptions.toBundle())
        }

    }
}