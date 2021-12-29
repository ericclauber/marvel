package com.eric.marvelapi.comics.ui.adapter

import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.eric.marvelapi.databinding.ComicLoadStateFooterItemBinding

class ComicLoadStateHolder(private val binding: ComicLoadStateFooterItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(loadState: LoadState) {

        binding.progressBar.isVisible = loadState is LoadState.Loading
    }
}