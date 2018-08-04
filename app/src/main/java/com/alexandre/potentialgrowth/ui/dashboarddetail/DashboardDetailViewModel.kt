package com.alexandre.potentialgrowth.ui.dashboarddetail

import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.ContributionRepo
import java.util.*

class DashboardDetailViewModel(private val contributionRepo: ContributionRepo, idTypeLearnItem: Int) : ViewModel() {

    var countContribution = contributionRepo.countHaveDoneforWeek(idTypeLearnItem, Date())
}