package com.alexandre.potentialgrowth.ui.home.knowledge

import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.model.LearnItem

/**
 * View model for the list of item to learn
 */
class KnowledgeFragmentViewModel(private val repository: LearnItemRepo) : ViewModel() {

    var mLearnItem = repository.getAllLearnItem()
}