package com.alexandre.potentialgrowth.data

import android.arch.lifecycle.LiveData
import com.alexandre.potentialgrowth.db.LearnItemDao
import com.alexandre.potentialgrowth.model.LearnItem
import com.alexandre.potentialgrowth.model.LearnItemWithContribution
import java.util.concurrent.Executor

/**
 * Repository class that works with local data sources. This repo will handle item to learn.
 */
class LearnItemRepo(private val learnItemDao: LearnItemDao, private val ioExecutor: Executor) {

    fun insert(learnItem: LearnItem) {
        ioExecutor.execute {
            learnItemDao.insert(learnItem)
        }
    }

    fun updateFav(idLearnItem: Long, isFavorites: Boolean) {
        ioExecutor.execute {
            learnItemDao.updateFavorite(idLearnItem, isFavorites)
        }
    }

    /**
     * Get all learn items
     */
    fun getAllLearnItem(): LiveData<List<LearnItemWithContribution>> {
        return learnItemDao.getAllLearnItem()
    }

    fun getAllFavLearnItem(): LiveData<List<LearnItemWithContribution>> {
        return learnItemDao.getFavAllLearnItem()
    }

    fun getLearnItemById(id : Long): LiveData<LearnItemWithContribution> {
        return learnItemDao.getLearnItem(id)
    }
}