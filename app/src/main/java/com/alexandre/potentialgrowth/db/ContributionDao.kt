package com.alexandre.potentialgrowth.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.alexandre.potentialgrowth.model.Contribution
import java.util.*

@Dao
interface ContributionDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contribution: Contribution)

    @Query("SELECT COUNT(idContribution) FROM contribution WHERE time BETWEEN :from AND :to AND :idLearnItem")
    fun countContributionforDate(from: Date, to: Date, idLearnItem: Long): LiveData<Int>
}