package com.alexandre.potentialgrowth.ui.dashboarddetail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.LearnItemRepo

/**
 * Factory for ViewModels
 */
class ViewModelFactoryDashboardDetail(private val repository: ContributionRepo, private val idTypeLearnItem : Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DashboardDetailViewModel(repository, idTypeLearnItem) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") as Throwable
    }
}