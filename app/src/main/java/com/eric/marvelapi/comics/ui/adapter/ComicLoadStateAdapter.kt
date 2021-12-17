package com.eric.marvelapi.comics.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.eric.marvelapi.R

class ComicLoadStateAdapter: LoadStateAdapter<ComicLoadStateHolder>() {
    override fun onBindViewHolder(holder: ComicLoadStateHolder, loadState: LoadState) {
        holder.bindItem(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ComicLoadStateHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.comic_load_state_footer_item, parent, false)
            .let { ComicLoadStateHolder(it) }
    }
}