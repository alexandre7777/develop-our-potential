package com.alexandre.potentialgrowth.ui.detail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.LearnItemRepo

/**
 * Factory for ViewModels
 */
class ViewModelFactoryDetail(private val learnItemRepo: LearnItemRepo, private val contributionRepo: ContributionRepo, private val idLearnItem : Long) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailActivityViewModel(learnItemRepo, contributionRepo, idLearnItem) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}