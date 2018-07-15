package com.alexandre.potentialgrowth.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.LearnItem
import com.bumptech.glide.Glide

class LearnItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.name)
    private val description: TextView = view.findViewById(R.id.description)
    private val img: ImageView = view.findViewById(R.id.img)

    private var learnItem: LearnItem? = null

    fun bind(learnItem: LearnItem?) {
        if (learnItem == null) {
            /*val resources = itemView.resources
            name.text = resources.getString(R.string.loading)
            description.visibility = View.GONE
            language.visibility = View.GONE
            stars.text = resources.getString(R.string.unknown)
            forks.text = resources.getString(R.string.unknown)*/
        } else {
            showRepoData(learnItem)
        }
    }

    private fun showRepoData(learnItem: LearnItem) {
        this.learnItem = learnItem
        name.text = learnItem.name
        description.text = learnItem.description
        Glide.with(img.context).load(learnItem.imgUrl).into(img)
    }

    companion object {
        fun create(parent: ViewGroup): LearnItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.learn_item_view_item, parent, false)
            return LearnItemViewHolder(view)
        }
    }
}