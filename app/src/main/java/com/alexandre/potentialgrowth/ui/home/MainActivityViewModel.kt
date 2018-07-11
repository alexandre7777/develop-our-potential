package com.alexandre.potentialgrowth.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.model.LearnItem

class MainActivityViewModel(private val repository: LearnItemRepo) : ViewModel() {

    fun addLearnItem(learnItem: LearnItem) {
        repository.insert(learnItem)
    }

    fun getAllLearnItem() : LiveData<List<LearnItem>> {
        return repository.getAllLearnItem()
    }
}