package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Object to store user progression
 * type 1 => "I have done it"
 * type 2 => comment
 */
@Entity(tableName = "contribution")
data class Contribution(@PrimaryKey(autoGenerate = true) val idContribution: Long,
                        @field:SerializedName("id_learn_item") val idLearnItem: Long,
                        @field:SerializedName("id_type") val idType: Int,
                        @field:SerializedName("time") val time: Date,
                        @field:SerializedName("result") val result: String){}