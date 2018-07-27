package com.alexandre.potentialgrowth.ui.home.knowledge

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem

class LearnItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.name)
    private val description: TextView = view.findViewById(R.id.description)
    private val img: ImageView = view.findViewById(R.id.img)
    private val container: ConstraintLayout = view.findViewById(R.id.container)


    private var learnItem: LearnItem? = null

    fun bind(learnItem: LearnItem?, listener: (View?, LearnItem) -> Unit) {
        if (learnItem == null) {
            /*val resources = itemView.resources
            name.text = resources.getString(R.string.loading)
            description.visibility = View.GONE
            language.visibility = View.GONE
            stars.text = resources.getString(R.string.unknown)
            forks.text = resources.getString(R.string.unknown)*/
        } else {
            showRepoData(learnItem, listener)
        }
    }

    private fun showRepoData(learnItem: LearnItem, listener: (View?, LearnItem) -> Unit) {
        this.learnItem = learnItem
        name.text = learnItem.name
        description.text = learnItem.description

        img.setImageDrawable(learnItem.getDrawable(img.context))

        container.setBackgroundColor(learnItem.getColor(container.context))

        name.setTextColor(learnItem.getTextColor(name.context))
        description.setTextColor(learnItem.getTextColor(description.context))

        this.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                listener(v, learnItem)
            }
        })
    }

    companion object {
        fun create(parent: ViewGroup): LearnItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.learn_item_view_item, parent, false)
            return LearnItemViewHolder(view)
        }
    }
}