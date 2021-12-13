package com.eric.marvelapi.comics.ui

import androidx.lifecycle.ViewModel
import com.eric.marvelapi.comics.api.ComicApi
import com.eric.marvelapi.comics.data.ComicRepository
import com.eric.marvelapi.comics.data.Keys
import com.eric.marvelapi.comics.model.Data
import com.eric.marvelapi.comics.ui.adapter.Mapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(private val repository: ComicRepository) : ViewModel() {

    fun getComics(): Flow<Data> {

       return repository.getComics()
    }
}