package com.alexandre.potentialgrowth.ui.yourdairy

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.Dairy

class DairyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val dairyTxt: TextView = view.findViewById(R.id.dairyTxt)
    private var dairy: Dairy? = null

    fun bind(dairy: Dairy?) {
        if (dairy != null) {
            showRepoData(dairy)
        }
    }

    private fun showRepoData(dairy: Dairy) {
        this.dairy = dairy

        dairyTxt.setText(dairy.dairyText)
    }

    companion object {
        fun create(parent: ViewGroup): DairyViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.dairy_item, parent, false)
            return DairyViewHolder(view)
        }
    }
}