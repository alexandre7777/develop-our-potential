package com.alexandre.potentialgrowth.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.alexandre.potentialgrowth.model.LearnItem

interface LearnItemDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<LearnItem>)

    @Query("SELECT * FROM learn_item")
    fun getAllLearnItem(): LiveData<List<LearnItem>>
}