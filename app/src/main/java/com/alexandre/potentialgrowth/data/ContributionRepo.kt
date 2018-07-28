package com.alexandre.potentialgrowth.data

import com.alexandre.potentialgrowth.db.ContributionDao
import com.alexandre.potentialgrowth.model.Contribution
import java.util.*
import java.util.concurrent.Executor

class ContributionRepo(private val contributionDao: ContributionDao, private val ioExecutor: Executor) {

    fun insert(contribution: Contribution) {
        ioExecutor.execute {
            contributionDao.insert(contribution)
        }
    }

    //fun countContributionForDay(idLearnItem: Long, time : Date) {
    //    contributionDao.countContributionforDate(time, time, idLearnItem)
    //}

}