package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Object to store answer linked to question
 */
@Entity(tableName = "answer")
data class Answer(
        @PrimaryKey @field:SerializedName("id_answer") val idAnswer: Long,
        @field:SerializedName("id_question") val idQuestion: Long,
        @field:SerializedName("label") val label: String,
        @field:SerializedName("order") val order: Int,
        @field:SerializedName("is_right") val isRight: Boolean) : Serializable