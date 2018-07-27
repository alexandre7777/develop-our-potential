package com.alexandre.potentialgrowth.ui.home.knowledge

import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
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

        when (learnItem.idType){
            1 -> {
                container.setBackgroundColor(ContextCompat.getColor(container.context, R.color.communication))
                img.setImageDrawable(ContextCompat.getDrawable(img.context, R.drawable.people))
                name.setTextColor(ContextCompat.getColor(container.context, R.color.white))
                description.setTextColor(ContextCompat.getColor(container.context, R.color.white))
            }
            2 -> {
                container.setBackgroundColor(ContextCompat.getColor(container.context, R.color.life_style))
                img.setImageDrawable(ContextCompat.getDrawable(img.context, R.drawable.thumb_up))
                name.setTextColor(ContextCompat.getColor(container.context, R.color.white))
                description.setTextColor(ContextCompat.getColor(container.context, R.color.white))
            }
            3 -> {
                container.setBackgroundColor(ContextCompat.getColor(container.context, R.color.self_confidence))
                img.setImageDrawable(ContextCompat.getDrawable(img.context, R.drawable.smile))
                name.setTextColor(ContextCompat.getColor(container.context, R.color.black))
                description.setTextColor(ContextCompat.getColor(container.context, R.color.black))
            }
            4 -> {
                container.setBackgroundColor(ContextCompat.getColor(container.context, R.color.health))
                img.setImageDrawable(ContextCompat.getDrawable(img.context, R.drawable.heart))
                name.setTextColor(ContextCompat.getColor(container.context, R.color.black))
                description.setTextColor(ContextCompat.getColor(container.context, R.color.black))
            }
            5 -> {
                container.setBackgroundColor(ContextCompat.getColor(container.context, R.color.white))
                img.setImageDrawable(ContextCompat.getDrawable(img.context, R.drawable.cake))
                name.setTextColor(ContextCompat.getColor(container.context, R.color.black))
                description.setTextColor(ContextCompat.getColor(container.context, R.color.black))
            }
        }



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