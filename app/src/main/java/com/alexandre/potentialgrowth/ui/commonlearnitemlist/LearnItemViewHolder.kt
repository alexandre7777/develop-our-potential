package com.alexandre.potentialgrowth.ui.commonlearnitemlist

import android.os.Build
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem

/**
 * View Holder for displaying item on the second home tab
 */
class LearnItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.name)
    private val description: TextView = view.findViewById(R.id.description)
    private val img: ImageView = view.findViewById(R.id.img)
    private val imgFav: ImageView = view.findViewById(R.id.imgFav)
    private val container: ConstraintLayout = view.findViewById(R.id.container)


    private var learnItem: LearnItem? = null

    fun bind(learnItem: LearnItem?, listener: (View?, LearnItem) -> Unit, listenerFav: (View?, LearnItem) -> Unit) {
        if (learnItem != null) {
            showRepoData(learnItem, listener, listenerFav)
        }
    }

    /**
     * Set colors and text for the item
     */
    private fun showRepoData(learnItem: LearnItem, listener: (View?, LearnItem) -> Unit, listenerFav: (View?, LearnItem) -> Unit) {
        this.learnItem = learnItem
        name.text = learnItem.name

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            description.text = Html.fromHtml(learnItem.description, Html.FROM_HTML_MODE_LEGACY)
        }
        else
        {
            description.text = Html.fromHtml(learnItem.description)
        }

        img.setImageDrawable(learnItem.getDrawable(img.context))

        imgFav.setImageDrawable(learnItem.getFavDrawable(img.context))

        container.setBackgroundColor(learnItem.getColor(container.context))

        name.setTextColor(learnItem.getTextColor(name.context))
        description.setTextColor(learnItem.getTextColor(description.context))

        this.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                listener(v, learnItem)
            }
        })

        imgFav.setOnClickListener{
            listenerFav(it, learnItem)
        }
    }

    companion object {
        fun create(parent: ViewGroup): LearnItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.learn_item_view_item, parent, false)
            return LearnItemViewHolder(view)
        }
    }
}