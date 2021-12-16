package com.eric.marvelapi.comics.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.eric.marvelapi.R
import com.eric.marvelapi.comics.model.ComicModel

class ComicsAdapter() :
    PagingDataAdapter<ComicModel, RecyclerView.ViewHolder>(COMIC_MODEL_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.comic_item, parent, false)
            .let { ComicsViewHolder(parent.context, it) }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ComicsViewHolder).bindItem(getItem(position) as ComicModel)
    }

    override fun getItemViewType(position: Int) = position

    companion object {
        private val COMIC_MODEL_COMPARATOR = object : DiffUtil.ItemCallback<ComicModel>() {
            override fun areItemsTheSame(oldItem: ComicModel, newItem: ComicModel): Boolean {
                return oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: ComicModel, newItem: ComicModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}