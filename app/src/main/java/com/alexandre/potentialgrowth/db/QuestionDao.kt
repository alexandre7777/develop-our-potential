package com.alexandre.potentialgrowth.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import com.alexandre.potentialgrowth.model.Question

@Dao
interface QuestionDao{

    @Insert
    fun insertAll(questions: List<Question>)
}