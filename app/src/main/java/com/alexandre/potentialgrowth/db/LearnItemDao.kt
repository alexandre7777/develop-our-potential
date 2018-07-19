package com.alexandre.potentialgrowth.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.alexandre.potentialgrowth.model.LearnItem

@Dao
interface LearnItemDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(learnItem: LearnItem)

    @Insert
    fun insertAll(learnItems: List<LearnItem>)

    @Query("SELECT idLearnItem, name, description, imgUrl FROM learn_item")
    fun getAllLearnItem(): LiveData<List<LearnItem>>
}