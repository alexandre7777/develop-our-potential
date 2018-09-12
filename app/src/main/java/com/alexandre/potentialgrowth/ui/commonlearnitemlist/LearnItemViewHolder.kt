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
import com.alexandre.potentialgrowth.model.LearnItemWithContribution
import com.alexandre.potentialgrowth.model.UtilLearnItem

/**
 * View Holder for displaying item on the second home tab
 */
class LearnItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.name)
    private val description: TextView = view.findViewById(R.id.description)
    private val img: ImageView = view.findViewById(R.id.img)
    private val imgFav: ImageView = view.findViewById(R.id.imgFav)
    private val container: ConstraintLayout = view.findViewById(R.id.container)
    private val countDone: TextView = view.findViewById(R.id.countDone)
    private val countComment: TextView = view.findViewById(R.id.countComment)
    private val imgCountDone: ImageView = view.findViewById(R.id.imgCountDone)
    private val imgCountComment: ImageView = view.findViewById(R.id.imgCountComment)


    private var learnItemWithContribution: LearnItemWithContribution? = null

    fun bind(learnItem: LearnItemWithContribution?, listener: (View?, LearnItemWithContribution) -> Unit, listenerFav: (View?, LearnItemWithContribution) -> Unit) {
        if (learnItem != null) {
            showRepoData(learnItem, listener, listenerFav)
        }
    }

    /**
     * Set colors and text for the item
     */
    private fun showRepoData(learnItemWithContribution: LearnItemWithContribution, listener: (View?, LearnItemWithContribution) -> Unit, listenerFav: (View?, LearnItemWithContribution) -> Unit) {
        this.learnItemWithContribution = learnItemWithContribution
        name.text = learnItemWithContribution.name

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            description.text = Html.fromHtml(learnItemWithContribution.description, Html.FROM_HTML_MODE_LEGACY)
        }
        else
        {
            description.text = Html.fromHtml(learnItemWithContribution.description)
        }

        img.setImageDrawable(UtilLearnItem.getDrawable(img.context, learnItemWithContribution.idType))

        imgFav.setImageDrawable(UtilLearnItem.getFavDrawable(img.context,
                learnItemWithContribution.idType,
                learnItemWithContribution.isFavorite))

        container.setBackground(UtilLearnItem.getColor(container.context, learnItemWithContribution.idType))

        name.setTextColor(UtilLearnItem.getTextColor(name.context, learnItemWithContribution.idType))
        description.setTextColor(UtilLearnItem.getTextColor(description.context, learnItemWithContribution.idType))

        countDone.text = learnItemWithContribution.countDone.toString()
        countComment.text = learnItemWithContribution.countComment.toString()

        countDone.setTextColor(UtilLearnItem.getTextColor(countDone.context, learnItemWithContribution.idType))
        countComment.setTextColor(UtilLearnItem.getTextColor(countComment.context, learnItemWithContribution.idType))

        imgCountDone.setImageDrawable(UtilLearnItem.getDoneDrawable(imgCountDone.context, learnItemWithContribution.idType))
        imgCountComment.setImageDrawable(UtilLearnItem.getCommentDrawable(imgCountComment.context, learnItemWithContribution.idType))

        this.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                listener(v, learnItemWithContribution)
            }
        })

        imgFav.setOnClickListener{
            listenerFav(it, learnItemWithContribution)
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