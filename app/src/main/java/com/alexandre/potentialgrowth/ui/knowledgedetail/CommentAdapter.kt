package com.alexandre.potentialgrowth.ui.knowledgedetail

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.alexandre.potentialgrowth.model.Contribution

class CommentAdapter( val listener: (View?, Contribution) -> Unit) : ListAdapter<Contribution, RecyclerView.ViewHolder>(CommentAdapter.REPO_COMPARATOR) {

    public var color: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommentViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as CommentViewHolder).bind(repoItem, color, listener)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Contribution>() {
            override fun areItemsTheSame(oldItem: Contribution, newItem: Contribution): Boolean =
                    oldItem.idContribution == newItem.idContribution

            override fun areContentsTheSame(oldItem: Contribution, newItem: Contribution): Boolean =
                    oldItem == newItem
        }
    }
}