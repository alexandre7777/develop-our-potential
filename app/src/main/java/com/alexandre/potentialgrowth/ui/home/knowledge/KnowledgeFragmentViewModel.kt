package com.alexandre.potentialgrowth.ui.home.knowledge

import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.model.LearnItem

/**
 * View model for the list of item to learn
 */
class KnowledgeFragmentViewModel(private val repository: LearnItemRepo) : ViewModel() {

    var mLearnItem = repository.getAllLearnItem()

    /**
     * store a new "I have done it"
     */
    public fun updateFav(learnItem: LearnItem?) {
        if (learnItem != null)
            repository.updateFav(learnItem.idLearnItem, !learnItem.isFavorite)
    }
}