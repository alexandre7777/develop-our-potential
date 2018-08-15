package com.alexandre.potentialgrowth.ui.yourdairy

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.DairyRepo

class ViewModelFactoryAddDialog(private val dairyRepo: DairyRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddDialogFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddDialogFragmentViewModel(dairyRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}