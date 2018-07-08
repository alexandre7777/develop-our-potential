package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "learn_item")
class LearnItem(
        @PrimaryKey @field:SerializedName("id") val id: Long,
        @field:SerializedName("name") val name: String,
        @field:SerializedName("description") val description: String?,
        @field:SerializedName("img_url") val imgUrl: String
)