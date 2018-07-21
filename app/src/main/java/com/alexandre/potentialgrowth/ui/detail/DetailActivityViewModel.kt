package com.alexandre.potentialgrowth.ui.detail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.model.LearnItem

class DetailActivityViewModel(private val repository: LearnItemRepo, idLearnItem: Long) : ViewModel() {

    public var learnItem : LiveData<LearnItem> = repository.getLearnItemById(idLearnItem)
}