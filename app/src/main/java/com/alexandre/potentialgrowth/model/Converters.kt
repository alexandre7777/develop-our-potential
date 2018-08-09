package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * Date converters time to date, date to time
 */
class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

}