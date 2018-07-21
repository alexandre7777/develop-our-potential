package com.alexandre.potentialgrowth.ui.detail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.LearnItemRepo

/**
 * Factory for ViewModels
 */
class ViewModelFactoryDetail(private val repository: LearnItemRepo, private val idLearnItem : Long) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailActivityViewModel(repository, idLearnItem) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}