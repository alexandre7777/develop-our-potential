package com.alexandre.potentialgrowth.ui.knowledgedetail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.model.Contribution
import java.text.SimpleDateFormat
import java.util.*

/**
 * View Holder to display comment made on an item to learn
 */
class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val dateTxt: TextView = view.findViewById(R.id.dateTxt)
    private val commentTxt: TextView = view.findViewById(R.id.commentTxt)
    private var contribution: Contribution? = null

    fun bind(contribution: Contribution?, color: Int, listener: (View?, Contribution) -> Unit) {
        if (contribution != null) {
            showRepoData(contribution, color, listener)
        }
    }

    private fun showRepoData(contribution: Contribution, color: Int, listener: (View?, Contribution) -> Unit) {
        this.contribution = contribution

        dateTxt.text =  dateTxt.context.getString(R.string.date_comment, SimpleDateFormat("dd/MM/yyy", Locale.getDefault()).format(contribution.time))
        commentTxt.text = contribution.result
        dateTxt.setTextColor(color)
        commentTxt.setTextColor(color)

        this.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                listener(v, contribution)
            }
        })
    }

    companion object {
        fun create(parent: ViewGroup): CommentViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.comment_view_item, parent, false)
            return CommentViewHolder(view)
        }
    }
}