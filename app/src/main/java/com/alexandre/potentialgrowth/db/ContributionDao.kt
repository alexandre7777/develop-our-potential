package com.alexandre.potentialgrowth.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.alexandre.potentialgrowth.model.Contribution
import java.util.*

/**
 * DAO to manage progress made by the user
 */
@Dao
interface ContributionDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contribution: Contribution)

    @Query("SELECT COUNT(idContribution) FROM contribution WHERE time BETWEEN :from AND :to AND idLearnItem = :idLearnItem AND idType = 1")
    fun countHaveDoneforDate(from: Date, to: Date, idLearnItem: Long): LiveData<Int>

    @Query("SELECT COUNT(idContribution) FROM contribution LEFT JOIN learn_item ON contribution.idLearnItem = learn_item.idLearnItem WHERE time BETWEEN :from AND :to AND learn_item.idType = :idType")
    fun countHaveDoneforDateAndType(from: Date, to: Date, idType: Int): LiveData<Int>

    @Query("SELECT idContribution, idLearnItem, idType, time, result FROM contribution WHERE idLearnItem = :id AND idType = 2 ORDER BY time DESC")
    fun getContributionForLearnItem(id : Long): LiveData<List<Contribution>>

    @Query("SELECT COUNT(idContribution) FROM contribution WHERE idType = :idType")
    fun countHaveDone(idType: Int): LiveData<Int>
}