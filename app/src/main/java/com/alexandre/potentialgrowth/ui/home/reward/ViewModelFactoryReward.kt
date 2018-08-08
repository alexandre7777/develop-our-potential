package com.alexandre.potentialgrowth.ui.home.reward

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.ContributionRepo

/**
 * Factory for ViewModels
 */
class ViewModelFactoryReward(private val repository: ContributionRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RewardFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RewardFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") as Throwable
    }
}