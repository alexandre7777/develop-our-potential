package com.alexandre.potentialgrowth.ui.knowledgedetail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.LearnItemRepo

/**
 * Factory for ViewModels
 */
class ViewModelFactoryKnowledgeDetail(private val learnItemRepo: LearnItemRepo, private val contributionRepo: ContributionRepo, private val idLearnItem : Long) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KnowledgeDetailActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return KnowledgeDetailActivityViewModel(learnItemRepo, contributionRepo, idLearnItem) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}