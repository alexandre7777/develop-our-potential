package com.alexandre.potentialgrowth.data

import android.arch.lifecycle.LiveData
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

    fun countHaveDoneforDate(idLearnItem: Long, time : Date): LiveData<Int> {

        val cal = GregorianCalendar.getInstance()
        cal.setTime(time)
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val date = cal.get(Calendar.DATE)

        val cal2 = GregorianCalendar.getInstance()
        cal2.set(year, month, date, 0, 0, 0)

        val cal3 = GregorianCalendar.getInstance()
        cal3.set(year, month, date + 1, 0, 0, 0)

        return contributionDao.countHaveDoneforDate(cal2.time, cal3.time, idLearnItem)
    }

    fun getContributionForLearnItem(idLearnItem: Long) : LiveData<List<Contribution>>{
        return contributionDao.getContributionForLearnItem(idLearnItem)
    }
}