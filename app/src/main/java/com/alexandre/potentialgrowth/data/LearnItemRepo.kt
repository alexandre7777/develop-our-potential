package com.alexandre.potentialgrowth.data

import android.arch.lifecycle.LiveData
import com.alexandre.potentialgrowth.db.LearnItemDao
import com.alexandre.potentialgrowth.model.LearnItem
import java.util.concurrent.Executor

/**
 * Repository class that works with local and remote data sources.
 */
class LearnItemRepo(private val learnItemDao: LearnItemDao, private val ioExecutor: Executor) {

    fun insert(learnItem: LearnItem) {
        ioExecutor.execute {
            learnItemDao.insert(learnItem)
        }
    }

    /**
     * Get all learn items
     */
    fun getAllLearnItem(): LiveData<List<LearnItem>> {
        return learnItemDao.getAllLearnItem()
    }

    fun getLearnItemById(id : Long): LiveData<LearnItem> {
        return learnItemDao.getLearnItem(id)
    }
}