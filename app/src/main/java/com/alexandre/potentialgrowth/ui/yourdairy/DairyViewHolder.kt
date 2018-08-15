package com.alexandre.potentialgrowth.ui.yourdairy

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.Dairy
import java.text.SimpleDateFormat
import java.util.*

class DairyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val dairyTxt: TextView = view.findViewById(R.id.dairyTxt)
    private val typeTxt: TextView = view.findViewById(R.id.typeTxt)
    private val dateTxt: TextView = view.findViewById(R.id.dateTxt)
    private var dairy: Dairy? = null

    fun bind(dairy: Dairy?) {
        if (dairy != null) {
            showRepoData(dairy)
        }
    }

    private fun showRepoData(dairy: Dairy) {
        this.dairy = dairy

        dairyTxt.text = dairy.dairyText

        typeTxt.text = dairy.getTypeText(typeTxt.context)

        typeTxt.background = dairy.getTypeBackgroundDrawable(typeTxt.context)

        dateTxt.text =  dateTxt.context.getString(R.string.date_dairy, SimpleDateFormat("MM/dd/yyy", Locale.getDefault()).format(dairy.time))
    }

    companion object {
        fun create(parent: ViewGroup): DairyViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.dairy_item, parent, false)
            return DairyViewHolder(view)
        }
    }
}