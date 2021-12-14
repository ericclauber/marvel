package com.eric.marvelapi.comics.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eric.marvelapi.R
import com.eric.marvelapi.comics.model.ComicModel

class ComicsAdapter(val comicList: MutableList<ComicModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.comic_item, parent, false)
            .let { ComicsViewHolder(parent.context, it) }
    }

    override fun getItemCount() = comicList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ComicsViewHolder).bindItem(comicList[position])
    }

    override fun getItemViewType(position: Int) = position
}