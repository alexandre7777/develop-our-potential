package com.alexandre.potentialgrowth.ui.knowledgedetail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.ContributionRepo
import com.alexandre.potentialgrowth.data.DairyRepo

class ViewModelFactoryAddDialogComment(private val contributionRepo: ContributionRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddDialogCommentFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddDialogCommentFragmentViewModel(contributionRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}