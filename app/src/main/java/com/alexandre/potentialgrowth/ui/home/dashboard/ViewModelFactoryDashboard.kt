package com.alexandre.potentialgrowth.ui.home.dashboard

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.ContributionRepo

/**
 * Factory for ViewModels
 */
class ViewModelFactoryDashboard(private val repository: ContributionRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashBoardFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DashBoardFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") as Throwable
    }
}