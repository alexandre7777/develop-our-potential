package com.alexandre.potentialgrowth.ui.yourdairy

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.alexandre.potentialgrowth.model.Dairy

class DairyAdapter : ListAdapter<Dairy, RecyclerView.ViewHolder>(DairyAdapter.REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DairyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as DairyViewHolder).bind(repoItem)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Dairy>() {
            override fun areItemsTheSame(oldItem: Dairy, newItem: Dairy): Boolean =
                    oldItem.idDairy == newItem.idDairy

            override fun areContentsTheSame(oldItem: Dairy, newItem: Dairy): Boolean =
                    oldItem == newItem
        }
    }
}