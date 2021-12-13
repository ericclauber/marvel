package com.eric.marvelapi.comics.ui

import androidx.lifecycle.ViewModel
import com.eric.marvelapi.comics.api.ComicApi
import com.eric.marvelapi.comics.data.Keys
import com.eric.marvelapi.comics.model.Data
import com.eric.marvelapi.comics.ui.adapter.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ComicsViewModel : ViewModel() {

    var response: Flow<Data>? = null

    fun getComics(): Flow<Data> {
        val api = RetrofitBuilder
            .createAPI(
                "https://gateway.marvel.com/",
                ComicApi::class.java
            ) as ComicApi

        return flow {
           emit(Mapper.mapper(
               api.getComics(
                   25,
                   1,
                   Keys.getTimeStamp(),
                   Keys.getApiKey(),
                   Keys.getHash()
               ).data)
            )
        }
    }
}