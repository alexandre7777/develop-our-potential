package com.alexandre.potentialgrowth.data

import android.arch.lifecycle.LiveData
import com.alexandre.potentialgrowth.db.DairyDao
import com.alexandre.potentialgrowth.db.LearnItemDao
import com.alexandre.potentialgrowth.model.Dairy
import com.alexandre.potentialgrowth.model.LearnItem
import java.util.concurrent.Executor

/**
 * Repository class that works with local data sources. This repo will handle dairy entries.
 */
class DairyRepo(private val dairyDao: DairyDao, private val ioExecutor: Executor) {

    fun insert(dairy: Dairy) {
        ioExecutor.execute {
            dairyDao.insert(dairy)
        }
    }

    fun getAllDairy(): LiveData<List<Dairy>> {
        return dairyDao.getAllDairy()
    }
}