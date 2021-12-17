package com.eric.marvelapi.comics.ui.adapter

import android.view.View
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.comic_load_state_footer_item.view.*

class ComicLoadStateHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun bindItem(loadState: LoadState) {

        itemView.progressBar.isVisible = loadState is LoadState.Loading
    }
}