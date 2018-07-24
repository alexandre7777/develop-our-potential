package com.alexandre.potentialgrowth.ui.home.knowledge

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.LearnItemRepo

/**
 * Factory for ViewModels
 */
class ViewModelFactoryKnowledge(private val repository: LearnItemRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KnowledgeFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return KnowledgeFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") as Throwable
    }
}