package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import com.alexandre.potentialgrowth.R
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
                 @field:SerializedName("time") val time: Date){

    public fun getTypeBackgroundDrawable(context : Context) : Drawable? {
        when (idType){
            1 -> {
                return ContextCompat.getDrawable(context, R.drawable.round_blue_background)
            }
            2 -> {
                return ContextCompat.getDrawable(context, R.drawable.round_orange_background)
            }
            3 -> {
                return ContextCompat.getDrawable(context, R.drawable.round_green_background)
            }
        }
        return ContextCompat.getDrawable(context, R.drawable.round_blue_background)
    }

    public fun getTypeText(context : Context) : String {
        when (idType){
            1 -> {
                return context.getString(R.string.goals)
            }
            2 -> {
                return context.getString(R.string.stories)
            }
            3 -> {
                return context.getString(R.string.ideas)
            }
        }
        return ""
    }
}