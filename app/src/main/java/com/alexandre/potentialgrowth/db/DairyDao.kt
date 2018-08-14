package com.alexandre.potentialgrowth.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.alexandre.potentialgrowth.model.Dairy
import com.alexandre.potentialgrowth.model.LearnItem

/**
 * DAO to manage dairy
 */
@Dao
interface DairyDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dairy: Dairy)

    @Query("SELECT idDairy, idType, dairyText FROM dairy")
    fun getAllDairy(): LiveData<List<Dairy>>
}