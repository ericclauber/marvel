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
import com.eric.marvelapi.comics.ui.adapter.ComicLoadStateAdapter
import com.eric.marvelapi.comics.ui.adapter.ComicsAdapter
import com.eric.marvelapi.databinding.FragmentComicsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ComicsFragment : Fragment() {

    private val viewModel: ComicsViewModel by viewModels()
    private val adapter = ComicsAdapter()
    private lateinit var binding: FragmentComicsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentComicsBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
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

        binding.reciclerView.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.reciclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        binding.reciclerView.adapter =
            adapter.withLoadStateFooter(ComicLoadStateAdapter())
    }

    private fun configureLoadStateAdapter() {
        adapter.addLoadStateListener { combinedLoadStates ->
            binding.reciclerView.isVisible =
                combinedLoadStates.mediator?.refresh is LoadState.NotLoading
            binding.progressBar.isVisible =
                combinedLoadStates.mediator?.refresh is LoadState.Loading
            binding.retryButton.isVisible = combinedLoadStates.mediator?.refresh is LoadState.Error
        }

        binding.retryButton.setOnClickListener { adapter.retry() }
    }
}