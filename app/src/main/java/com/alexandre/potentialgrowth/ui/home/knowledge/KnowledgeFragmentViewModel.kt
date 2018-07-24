package com.alexandre.potentialgrowth.ui.home.knowledge

import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.model.LearnItem

class KnowledgeFragmentViewModel(private val repository: LearnItemRepo) : ViewModel() {

    var mLearnItem = repository.getAllLearnItem()

    fun addLearnItem(learnItem: LearnItem) {
        repository.insert(learnItem)
    }

    fun getAllLearnItem() {
        mLearnItem = repository.getAllLearnItem()
    }
}