package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import com.alexandre.potentialgrowth.R
import com.google.gson.annotations.SerializedName

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
        @field:SerializedName("is_favorite") val isFavorite: Boolean) {


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

    public fun getProgressDrawable(context : Context) : Drawable? {
        when (idType){
            1 -> {
                return ContextCompat.getDrawable(context, R.drawable.circular_progress_bar_blue)
            }
            2 -> {
                return ContextCompat.getDrawable(context, R.drawable.circular_progress_bar_red)
            }
            3 -> {
                return ContextCompat.getDrawable(context, R.drawable.circular_progress_bar_yellow)
            }
            4 -> {
                return ContextCompat.getDrawable(context, R.drawable.circular_progress_bar_green)
            }
            5 -> {
                return ContextCompat.getDrawable(context, R.drawable.circular_progress_bar_black)
            }
        }
        return ContextCompat.getDrawable(context, R.drawable.circular_progress_bar_black)
    }

    public fun getFavDrawable(context : Context) : Drawable? {
        when (idType){
            1 -> {
                return ContextCompat.getDrawable(context, R.drawable.ic_full_star_white)
            }
            2 -> {
                return ContextCompat.getDrawable(context, R.drawable.ic_full_star_white)
            }
            3 -> {
                return ContextCompat.getDrawable(context, R.drawable.ic_full_star_black)
            }
            4 -> {
                return ContextCompat.getDrawable(context, R.drawable.ic_full_star_white)
            }
            5 -> {
                return ContextCompat.getDrawable(context, R.drawable.ic_full_star_black)
            }
        }
        return ContextCompat.getDrawable(context, R.drawable.ic_full_star_white)
    }

    public fun getNotFavDrawable(context : Context) : Drawable? {
        when (idType){
            1 -> {
                return ContextCompat.getDrawable(context, R.drawable.ic_empty_star_white)
            }
            2 -> {
                return ContextCompat.getDrawable(context, R.drawable.ic_empty_star_white)
            }
            3 -> {
                return ContextCompat.getDrawable(context, R.drawable.ic_empty_star_black)
            }
            4 -> {
                return ContextCompat.getDrawable(context, R.drawable.ic_empty_star_white)
            }
            5 -> {
                return ContextCompat.getDrawable(context, R.drawable.ic_empty_star_black)
            }
        }
        return ContextCompat.getDrawable(context, R.drawable.ic_empty_star_white)
    }
}