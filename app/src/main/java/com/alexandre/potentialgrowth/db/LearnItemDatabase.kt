package com.alexandre.potentialgrowth.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.alexandre.potentialgrowth.model.LearnItem

/**
 * Database schema that holds the list of repos.
 */
@Database(
        entities = [LearnItem::class],
        version = 1,
        exportSchema = false
)
abstract class LearnItemDatabase : RoomDatabase() {

    abstract fun learnItemDao(): LearnItemDao

    companion object {

        @Volatile
        private var INSTANCE: LearnItemDatabase? = null

        fun getInstance(context: Context): LearnItemDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        LearnItemDatabase::class.java, "LearnRepo.db")
                        .build()
    }
}