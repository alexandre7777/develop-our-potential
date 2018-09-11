package com.alexandre.potentialgrowth.ui.home.dashboard

import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.ContributionRepo
import java.util.*

/**
 * View Model for the dashboard tab, contain progression for each of the 5 topics
 */
class DashBoardFragmentViewModel(private val repository: ContributionRepo) : ViewModel() {

    var countContributionCommunication = repository.countHaveDoneforWeek(1, Date())

    var countContributionLifeStyle = repository.countHaveDoneforWeek(2, Date())

    var countContributionSelfEsteem = repository.countHaveDoneforWeek(3, Date())

    var countContributionHealth = repository.countHaveDoneforWeek(4, Date())

    var countContributionFindYourself = repository.countHaveDoneforWeek(5, Date())

}