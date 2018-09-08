package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import com.alexandre.potentialgrowth.R
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Object to store item to learn
 * type 1 = communication
 * type 2 = life style
 * type 3 = self esteem
 * type 4 = physical health
 * type 5 = find yourself
 */
@Entity(tableName = "learn_item")
data class LearnItem(
        @PrimaryKey @field:SerializedName("id_learn_item") val idLearnItem: Long,
        @field:SerializedName("id_type") val idType: Int,
        @field:SerializedName("order_learn_item") val orderLearnItem: Int,
        @field:SerializedName("name") val name: String,
        @field:SerializedName("description") val description: String?,
        @field:SerializedName("img_url") val imgUrl: String,
        @field:SerializedName("is_favorite") val isFavorite: Boolean) : Serializable {
}