package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Object to store dairy entry
 * type 1 -> Goals
 * type 2 -> Stories
 * type 3 -> Ideas
 */
@Entity(tableName = "dairy")
data class Dairy(@PrimaryKey(autoGenerate = true) val idDairy: Long,
                 @field:SerializedName("id_type") val idType: Int,
                 @field:SerializedName("dairy_text") val dairyText: String,
                 @field:SerializedName("time") val time: Date){}