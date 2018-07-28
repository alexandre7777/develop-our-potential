package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import com.alexandre.potentialgrowth.R
import com.google.gson.annotations.SerializedName

@Entity(tableName = "learn_item")
data class LearnItem(
        @PrimaryKey @field:SerializedName("id_learn_item") val idLearnItem: Long,
        @field:SerializedName("id_type") val idType: Int,
        @field:SerializedName("order_learn_item") val orderLearnItem: Int,
        @field:SerializedName("name") val name: String,
        @field:SerializedName("description") val description: String?,
        @field:SerializedName("img_url") val imgUrl: String) {


    public fun getDrawable(context : Context) : Drawable? {
        when (idType){
            1 -> {
                return ContextCompat.getDrawable(context, R.drawable.people)
            }
            2 -> {
                return ContextCompat.getDrawable(context, R.drawable.thumb_up)
            }
            3 -> {
                return ContextCompat.getDrawable(context, R.drawable.smile)
            }
            4 -> {
                return ContextCompat.getDrawable(context, R.drawable.heart)
            }
            5 -> {
                return ContextCompat.getDrawable(context, R.drawable.cake)
            }
        }
        return ContextCompat.getDrawable(context, R.drawable.people)
    }

    public fun getColor(context : Context) : Int {
        when (idType){
            1 -> {
                return ContextCompat.getColor(context, R.color.communication)
            }
            2 -> {
                return ContextCompat.getColor(context, R.color.life_style)
            }
            3 -> {
                return ContextCompat.getColor(context, R.color.self_confidence)
            }
            4 -> {
                return ContextCompat.getColor(context, R.color.health)
            }
            5 -> {
                return ContextCompat.getColor(context, R.color.white)
            }
        }
        return ContextCompat.getColor(context, R.color.white)
    }

    public fun getTextColor(context : Context) : Int {
        when (idType){
            1 -> {
                return ContextCompat.getColor(context, R.color.white)
            }
            2 -> {
                return ContextCompat.getColor(context, R.color.white)
            }
            3 -> {
                return ContextCompat.getColor(context, R.color.black)
            }
            4 -> {
                return ContextCompat.getColor(context, R.color.black)
            }
            5 -> {
                return ContextCompat.getColor(context, R.color.black)
            }
        }
        return ContextCompat.getColor(context, R.color.black)
    }

    public fun getOppositeColor(context : Context) : Int {
        when (idType){
            1 -> {
                return ContextCompat.getColor(context, R.color.opposite_communication)
            }
            2 -> {
                return ContextCompat.getColor(context, R.color.opposite_life_style)
            }
            3 -> {
                return ContextCompat.getColor(context, R.color.opposite_self_confidence)
            }
            4 -> {
                return ContextCompat.getColor(context, R.color.opposite_health)
            }
            5 -> {
                return ContextCompat.getColor(context, R.color.black)
            }
        }
        return ContextCompat.getColor(context, R.color.black)
    }
}