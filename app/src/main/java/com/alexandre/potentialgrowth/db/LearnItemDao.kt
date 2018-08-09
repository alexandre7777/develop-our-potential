package com.alexandre.potentialgrowth.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.alexandre.potentialgrowth.model.LearnItem

/**
 * DAO to manage item to learn
 */
@Dao
interface LearnItemDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(learnItem: LearnItem)

    @Insert
    fun insertAll(learnItems: List<LearnItem>)

    @Query("SELECT idLearnItem, idType, orderLearnItem, name, description, imgUrl FROM learn_item ORDER BY orderLearnItem")
    fun getAllLearnItem(): LiveData<List<LearnItem>>

    @Query("SELECT idLearnItem, idType, orderLearnItem, name, description, imgUrl FROM learn_item WHERE idLearnItem = :id")
    fun getLearnItem(id : Long): LiveData<LearnItem>
}