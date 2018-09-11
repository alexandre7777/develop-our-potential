package com.alexandre.potentialgrowth.ui.home.dashboard

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.data.QuoteRepo

/**
 * Factory for ViewModels
 */
class ViewModelFactoryDashboard(private val repository: ContributionRepo, private val quoteRepo: QuoteRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashBoardFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DashBoardFragmentViewModel(repository, quoteRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") as Throwable
    }
}