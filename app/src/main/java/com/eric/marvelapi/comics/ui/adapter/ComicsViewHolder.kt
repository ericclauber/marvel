package com.eric.marvelapi.comics.ui.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.eric.core.extensions.toBRValue
import com.eric.marvelapi.R
import com.eric.marvelapi.comics.model.ComicModel
import com.eric.marvelapi.databinding.ComicItemBinding
import com.squareup.picasso.Picasso

class ComicsViewHolder (private val binding: ComicItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bindItem(item: ComicModel) {

            Picasso.get()
                .load(item.thumbnail?.path)
                .placeholder(R.drawable.load_image)
                .error(R.drawable.load_image_error)
                .into(binding.imageViewThumbnail)

            binding.textViewTitle.text = item.title
            binding.textViewPrice.text = item.price?.price?.toBRValue()
        }
    }