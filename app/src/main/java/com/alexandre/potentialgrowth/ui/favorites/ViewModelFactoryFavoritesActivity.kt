package com.alexandre.potentialgrowth.ui.favorites

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.LearnItemRepo

/**
 * Factory for ViewModels
 */
class ViewModelFactoryFavoritesActivity(private val learnItemRepo: LearnItemRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritesActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoritesActivityViewModel(learnItemRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}