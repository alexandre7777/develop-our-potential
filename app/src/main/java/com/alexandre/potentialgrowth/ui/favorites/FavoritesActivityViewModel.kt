package com.alexandre.potentialgrowth.ui.favorites

import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.model.LearnItem

class FavoritesActivityViewModel(private val learnItemRepo: LearnItemRepo) : ViewModel() {

    var mFavLearnItem = learnItemRepo.getAllFavLearnItem()

    /**
     * store a new "I have done it"
     */
    public fun updateFav(learnItem: LearnItem?) {
        if (learnItem != null)
            learnItemRepo.updateFav(learnItem.idLearnItem, !learnItem.isFavorite)
    }
}