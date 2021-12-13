package com.eric.marvelapi.comics.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.eric.marvelapi.R
import com.eric.marvelapi.comics.ui.adapter.ComicsAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ComicsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ComicsViewModel()

        lifecycleScope.launch {
            viewModel.getComics().collectLatest {
                ComicsAdapter(it.results.toMutableList())
         //       comicReciclerView
            }
        }
    }
}