package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "learn_item")
data class LearnItem(
        @PrimaryKey @field:SerializedName("id_learn_item") val idLearnItem: Long,
        @field:SerializedName("id_type") val idType: Int,
        @field:SerializedName("order_learn_item") val orderLearnItem: Int,
        @field:SerializedName("name") val name: String,
        @field:SerializedName("description") val description: String?,
        @field:SerializedName("img_url") val imgUrl: String
)