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

/**
 * Dashboard tab in the home, display weekly progress for each of the 5 topics
 */
class DashBoardFragment : Fragment(){

    public val INTENT_DETAIL_EXTRA = "intentdetailextrakey"

    public val INTENT_DETAIL_EXTRA_TEXT = "intentdetailextratextkey"

    private lateinit var viewModelDashboard: DashBoardFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModelDashboard = ViewModelProviders.of(this, Injection.provideViewModelFactoryDashboard(activity!!, activity!!.application))
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

    /**
     * Init click for each of the 5 card view displayed on the screen
     */
    private fun initListener() {

        lifeStyleCL.setOnClickListener() {
            val intent = Intent(activity, DashboardDetailActivity::class.java).apply {
                putExtra(INTENT_DETAIL_EXTRA, 2)
                putExtra(INTENT_DETAIL_EXTRA_TEXT, resources.getString(R.string.life_style))
            }

            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity as Activity,

                    Pair<View, String>(view?.findViewById(R.id.progressBarLifeStyle),
                            DashboardDetailActivity().VIEW_PROGRESSION_PROGRESS),
                    Pair<View, String>(activity?.findViewById(R.id.appBarLayout),
                            DashboardDetailActivity().VIEW_NAME_APPBARLAYOUT),
                    Pair<View, String>(activity?.findViewById(R.id.imageViewLifeStyle),
                            DashboardDetailActivity().VIEW_IMG_PICTO),
                    Pair<View, String>(activity?.findViewById(R.id.txtLifeStyle),
                            DashboardDetailActivity().VIEW_TXT_TITLE))


            ActivityCompat.startActivity(activity as Activity, intent, activityOptions.toBundle())
        }

        communicationCL.setOnClickListener() {
            val intent = Intent(activity, DashboardDetailActivity::class.java).apply {
                putExtra(INTENT_DETAIL_EXTRA, 1)
                putExtra(INTENT_DETAIL_EXTRA_TEXT, resources.getString(R.string.communication))
            }

            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity as Activity,

                    Pair<View, String>(view?.findViewById(R.id.progressBarCommunication),
                            DashboardDetailActivity().VIEW_PROGRESSION_PROGRESS),
                    Pair<View, String>(activity?.findViewById(R.id.appBarLayout),
                            DashboardDetailActivity().VIEW_NAME_APPBARLAYOUT),
                    Pair<View, String>(activity?.findViewById(R.id.imageViewCommunication),
                            DashboardDetailActivity().VIEW_IMG_PICTO),
                    Pair<View, String>(activity?.findViewById(R.id.txtCommunication),
                            DashboardDetailActivity().VIEW_TXT_TITLE))

            ActivityCompat.startActivity(activity as Activity, intent, activityOptions.toBundle())
        }

        healthCL.setOnClickListener() {
            val intent = Intent(activity, DashboardDetailActivity::class.java).apply {
                putExtra(INTENT_DETAIL_EXTRA, 4)
                putExtra(INTENT_DETAIL_EXTRA_TEXT, resources.getString(R.string.health))
            }

            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity as Activity,

                    Pair<View, String>(view?.findViewById(R.id.progressBarHealth),
                            DashboardDetailActivity().VIEW_PROGRESSION_PROGRESS),
                    Pair<View, String>(activity?.findViewById(R.id.appBarLayout),
                            DashboardDetailActivity().VIEW_NAME_APPBARLAYOUT),
                    Pair<View, String>(activity?.findViewById(R.id.imageViewHeath),
                            DashboardDetailActivity().VIEW_IMG_PICTO),
                    Pair<View, String>(activity?.findViewById(R.id.txtHealth),
                            DashboardDetailActivity().VIEW_TXT_TITLE))

            ActivityCompat.startActivity(activity as Activity, intent, activityOptions.toBundle())
        }

        selfConfidenceCL.setOnClickListener() {
            val intent = Intent(activity, DashboardDetailActivity::class.java).apply {
                putExtra(INTENT_DETAIL_EXTRA, 3)
                putExtra(INTENT_DETAIL_EXTRA_TEXT, resources.getString(R.string.self_confidence))
            }

            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity as Activity,

                    Pair<View, String>(view?.findViewById(R.id.progressBarSelfConfidence),
                            DashboardDetailActivity().VIEW_PROGRESSION_PROGRESS),
                    Pair<View, String>(activity?.findViewById(R.id.appBarLayout),
                            DashboardDetailActivity().VIEW_NAME_APPBARLAYOUT),
                    Pair<View, String>(activity?.findViewById(R.id.imageViewSelfConfidence),
                            DashboardDetailActivity().VIEW_IMG_PICTO),
                    Pair<View, String>(activity?.findViewById(R.id.txtSelfConfidence),
                            DashboardDetailActivity().VIEW_TXT_TITLE))

            ActivityCompat.startActivity(activity as Activity, intent, activityOptions.toBundle())
        }

        findYourselfCL.setOnClickListener() {
            val intent = Intent(activity, DashboardDetailActivity::class.java).apply {
                putExtra(INTENT_DETAIL_EXTRA, 5)
                putExtra(INTENT_DETAIL_EXTRA_TEXT, resources.getString(R.string.find_yourself))
            }

            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity as Activity,

                    Pair<View, String>(view?.findViewById(R.id.progressBarFindYourself),
                            DashboardDetailActivity().VIEW_PROGRESSION_PROGRESS),
                    Pair<View, String>(activity?.findViewById(R.id.appBarLayout),
                            DashboardDetailActivity().VIEW_NAME_APPBARLAYOUT),
                    Pair<View, String>(activity?.findViewById(R.id.imageViewFindYourself),
                            DashboardDetailActivity().VIEW_IMG_PICTO),
                    Pair<View, String>(activity?.findViewById(R.id.txtFindYourself),
                            DashboardDetailActivity().VIEW_TXT_TITLE))

            ActivityCompat.startActivity(activity as Activity, intent, activityOptions.toBundle())
        }
    }
}