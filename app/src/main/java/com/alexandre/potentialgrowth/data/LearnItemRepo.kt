package com.alexandre.potentialgrowth.data

import android.arch.lifecycle.LiveData
import com.alexandre.potentialgrowth.db.LearnItemDao
import com.alexandre.potentialgrowth.model.LearnItem

/**
 * Repository class that works with local and remote data sources.
 */
class LearnItemRepo(private val learnItemDao: LearnItemDao) {

    /**
     * Get all learn items
     */
    fun getAllLearnItem(): LiveData<List<LearnItem>> {

        // Get data from the local cache
        return learnItemDao.getAllLearnItem()
    }
}