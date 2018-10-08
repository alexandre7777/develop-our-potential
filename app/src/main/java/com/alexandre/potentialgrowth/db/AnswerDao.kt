package com.alexandre.potentialgrowth.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import com.alexandre.potentialgrowth.model.Answer

@Dao
interface AnswerDao{

    @Insert
    fun insertAll(answers: List<Answer>)
}