package com.alexandre.potentialgrowth.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.alexandre.potentialgrowth.model.LearnItem
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.TypeConverters
import com.alexandre.potentialgrowth.ioThread
import com.alexandre.potentialgrowth.model.Contribution
import com.alexandre.potentialgrowth.model.Converters
import com.alexandre.potentialgrowth.model.Dairy
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

/**
 * Database schema that holds the list of repos.
 */
@Database(
        entities = [LearnItem::class, Contribution::class, Dairy::class],
        version = 1,
        exportSchema = false
)
@TypeConverters(Converters::class)
abstract class LearnItemDatabase : RoomDatabase() {

    abstract fun learnItemDao(): LearnItemDao
    abstract fun contributionDao() : ContributionDao
    abstract fun dairyDao() : DairyDao

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
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)

                                //reading json from assets
                                val inputStream = context.applicationContext.assets.open("learnitem.json")
                                val reader = InputStreamReader(inputStream, "UTF-8")
                                val listType = object : TypeToken<ArrayList<LearnItem>>() {}.type
                                val result : ArrayList<LearnItem> = Gson().fromJson(reader, listType)

                                //insert result in db
                                ioThread {
                                    getInstance(context).learnItemDao().insertAll(result)
                                }
                            }
                        })
                        .build()
    }
}