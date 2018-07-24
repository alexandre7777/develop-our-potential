package com.alexandre.potentialgrowth.ui.home.knowledge

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.alexandre.potentialgrowth.model.LearnItem

class LearnItemAdapter(val listener: (LearnItem) -> Unit) : ListAdapter<LearnItem, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LearnItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as LearnItemViewHolder).bind(repoItem, listener)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<LearnItem>() {
            override fun areItemsTheSame(oldItem: LearnItem, newItem: LearnItem): Boolean =
                    oldItem.idLearnItem == newItem.idLearnItem

            override fun areContentsTheSame(oldItem: LearnItem, newItem: LearnItem): Boolean =
                    oldItem == newItem
        }
    }
}