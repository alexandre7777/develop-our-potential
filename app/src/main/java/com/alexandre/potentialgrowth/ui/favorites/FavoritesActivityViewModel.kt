package com.alexandre.potentialgrowth.ui.favorites

import android.arch.lifecycle.ViewModel
import com.alexandre.potentialgrowth.data.LearnItemRepo
import com.alexandre.potentialgrowth.model.LearnItem

class FavoritesActivityViewModel(private val learnItemRepo: LearnItemRepo) : ViewModel() {

    var mFavLearnItem = learnItemRepo.getAllFavLearnItem()

    var lastDeletedLearnItem : LearnItem? = null

    /**
     * store a new "I have done it"
     */
    public fun updateFav(learnItem: LearnItem?) {
        if (learnItem != null) {
            learnItemRepo.updateFav(learnItem.idLearnItem, !learnItem.isFavorite)
            lastDeletedLearnItem = learnItem
        }
    }

    public fun cancelDeleteFav()
    {
        val _lastDeletedLearnItem = lastDeletedLearnItem
        if(_lastDeletedLearnItem != null) {
            learnItemRepo.updateFav(_lastDeletedLearnItem.idLearnItem, _lastDeletedLearnItem.isFavorite)
        }
    }
}