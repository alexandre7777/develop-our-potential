package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "quote")
data class Quote(
        @PrimaryKey @field:SerializedName("id") var id: Int = 0,
        @field:SerializedName("author") var author: String = "",
        @field:SerializedName("body")var body: String = "",
        @field:SerializedName("time") var time: Date = Date()
)