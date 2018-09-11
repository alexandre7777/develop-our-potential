package com.alexandre.potentialgrowth.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.alexandre.potentialgrowth.model.Quote
import java.util.*

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(quote: Quote)

    @Query("SELECT * FROM quote WHERE time ORDER BY time DESC LIMIT 1")
    fun getTheLastQuote(): LiveData<Quote>

    @Query("DELETE FROM quote WHERE time < :time")
    fun deleteQuoteByTime(time: Long)
}