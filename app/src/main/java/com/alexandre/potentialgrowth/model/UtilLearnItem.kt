package com.alexandre.potentialgrowth.model

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import com.alexandre.potentialgrowth.R

object UtilLearnItem {

    fun getDrawable(context : Context, idType : Int) : Drawable? {
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

    fun getColor(context : Context, idType : Int) : Int {
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

    fun getTextColor(context : Context, idType : Int) : Int {
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

    fun getOppositeColor(context : Context, idType : Int) : Int {
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

    fun getProgressDrawable(context : Context, idType : Int) : Drawable? {
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

    fun getFavDrawable(context : Context, idType : Int, isFavorite : Boolean) : Drawable? {
        when (idType){
            1 -> {
                return getWhiteFav(context, isFavorite)
            }
            2 -> {
                return getWhiteFav(context, isFavorite)
            }
            3 -> {
                return getBlackFav(context, isFavorite)
            }
            4 -> {
                return getWhiteFav(context, isFavorite)
            }
            5 -> {
                return getBlackFav(context, isFavorite)
            }
        }
        return getWhiteFav(context, isFavorite)
    }

    private fun getBlackFav(context : Context, isFavorite : Boolean) : Drawable?{
        if(isFavorite)
            return  ContextCompat.getDrawable(context, R.drawable.ic_full_star_black)
        else
            return  ContextCompat.getDrawable(context, R.drawable.ic_empty_star_black)
    }

    private fun getWhiteFav(context : Context, isFavorite : Boolean) : Drawable?{
        if(isFavorite)
            return  ContextCompat.getDrawable(context, R.drawable.ic_full_star_white)
        else
            return  ContextCompat.getDrawable(context, R.drawable.ic_empty_star_white)
    }
}