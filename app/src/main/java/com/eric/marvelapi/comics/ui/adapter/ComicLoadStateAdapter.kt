package com.eric.marvelapi.comics.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.eric.marvelapi.R
import com.eric.marvelapi.databinding.ComicLoadStateFooterItemBinding

class ComicLoadStateAdapter: LoadStateAdapter<ComicLoadStateHolder>() {
    override fun onBindViewHolder(holder: ComicLoadStateHolder, loadState: LoadState) {
        holder.bindItem(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ComicLoadStateHolder {
        return ComicLoadStateFooterItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
            .let { ComicLoadStateHolder(it) }
    }
}