package com.alexandre.potentialgrowth.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.alexandre.potentialgrowth.db.ContributionDao
import com.alexandre.potentialgrowth.model.Contribution
import java.util.*
import java.util.concurrent.Executor

class ContributionRepo(private val contributionDao: ContributionDao, private val ioExecutor: Executor) {

    val BRONZE_LEVEL = 5
    val SILVER_LEVEL = 10
    val GOLD_LEVEL = 15

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

    fun countHaveDoneforWeek(idType: Int, time : Date): LiveData<Int> {

        val cal = GregorianCalendar.getInstance()
        cal.setTime(time)
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val date = cal.get(Calendar.DATE)

        val cal2 = GregorianCalendar.getInstance()
        cal2.set(year, month, date - 6, 0, 0, 0)

        val cal3 = GregorianCalendar.getInstance()
        cal3.set(year, month, date + 1, 0, 0, 0)

        return contributionDao.countHaveDoneforDateAndType(cal2.time, cal3.time, idType)
    }

    fun getContributionForLearnItem(idLearnItem: Long) : LiveData<List<Contribution>>{
        return contributionDao.getContributionForLearnItem(idLearnItem)
    }

    fun isBronzeDone(): LiveData<Boolean>{
        return Transformations.map(contributionDao.countHaveDone(1)) {
            it >= BRONZE_LEVEL
        }
    }

    fun isSilverDone(): LiveData<Boolean>{
        return Transformations.map(contributionDao.countHaveDone(1)) {
            it >= SILVER_LEVEL
        }
    }

    fun isGoldDone(): LiveData<Boolean>{
        return Transformations.map(contributionDao.countHaveDone(1)) {
            it >= GOLD_LEVEL
        }
    }
    fun isBronzeComment(): LiveData<Boolean>{
        return Transformations.map(contributionDao.countHaveDone(2)) {
            it >= BRONZE_LEVEL
        }
    }

    fun isSilverComment(): LiveData<Boolean>{
        return Transformations.map(contributionDao.countHaveDone(2)) {
            it >= SILVER_LEVEL
        }
    }

    fun isGoldComment(): LiveData<Boolean>{
        return Transformations.map(contributionDao.countHaveDone(2)) {
            it >= GOLD_LEVEL
        }
    }
}