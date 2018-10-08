package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Object to store question linked to answer and learn item
 * type 1 = one choice
 * type 2 = multi choices
 * type 3 = open answer
 */
@Entity(tableName = "question")
data class Question(
        @PrimaryKey @field:SerializedName("id_question") val idQuestion: Long,
        @field:SerializedName("id_learn_item") val idLearnItem: Long,
        @field:SerializedName("label") val label: String,
        @field:SerializedName("order") val order: Int,
        @field:SerializedName("id_type") val idType: Int) : Serializable