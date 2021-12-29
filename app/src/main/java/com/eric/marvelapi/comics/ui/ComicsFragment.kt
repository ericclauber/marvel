package com.eric.marvelapi.comics.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.eric.marvelapi.R
import com.eric.marvelapi.comics.ui.adapter.ComicLoadStateAdapter
import com.eric.marvelapi.comics.ui.adapter.ComicsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_comics.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ComicsFragment : Fragment() {

    private val viewModel: ComicsViewModel by viewModels()
    private val adapter = ComicsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
        init()
    }

    private fun init() {
        lifecycleScope.launch {
            viewModel.getComics().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun configureRecyclerView() {
        configureLoadStateAdapter()

        reciclerView.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        reciclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        reciclerView.adapter =
            adapter.withLoadStateFooter(ComicLoadStateAdapter())
    }

    private fun configureLoadStateAdapter() {
        adapter.addLoadStateListener { combinedLoadStates ->
            reciclerView.isVisible = combinedLoadStates.mediator?.refresh is LoadState.NotLoading
            progressBar.isVisible = combinedLoadStates.mediator?.refresh is LoadState.Loading
            retryButton.isVisible = combinedLoadStates.mediator?.refresh is LoadState.Error
        }

        retryButton.setOnClickListener { adapter.retry() }
    }
}