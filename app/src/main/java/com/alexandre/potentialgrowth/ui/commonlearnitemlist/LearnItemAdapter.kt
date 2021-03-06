package com.alexandre.potentialgrowth.ui.commonlearnitemlist

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.alexandre.potentialgrowth.model.LearnItemWithContribution

/**
 * Adapter for the Knowledge tab on the home page
 */
class LearnItemAdapter(private val listener: (View?, LearnItemWithContribution) -> Unit, private val listenerFav: (View?, LearnItemWithContribution) -> Unit) : ListAdapter<LearnItemWithContribution, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LearnItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as LearnItemViewHolder).bind(repoItem, listener, listenerFav)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<LearnItemWithContribution>() {
            override fun areItemsTheSame(oldItem: LearnItemWithContribution, newItem: LearnItemWithContribution): Boolean =
                    oldItem.idLearnItem == newItem.idLearnItem

            override fun areContentsTheSame(oldItem: LearnItemWithContribution, newItem: LearnItemWithContribution): Boolean =
                    oldItem == newItem
        }
    }
}