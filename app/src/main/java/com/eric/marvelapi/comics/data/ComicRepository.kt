package com.eric.marvelapi.comics.data

import com.eric.marvelapi.comics.api.ComicApi
import com.eric.marvelapi.comics.db.ComicDatabase
import com.eric.marvelapi.comics.model.Data
import com.eric.marvelapi.comics.ui.adapter.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import javax.inject.Inject

class ComicRepository @Inject constructor(
    private val service: Retrofit,
    private val database: ComicDatabase
) {

    fun getComics(): Flow<Data> {

        val api = service.create(ComicApi::class.java)

        return flow {
            emit(
                Mapper.mapper(
                    api.getComics(
                        25,
                        1,
                        Keys.getTimeStamp(),
                        Keys.getApiKey(),
                        Keys.getHash()
                    ).data
                )
            )
        }
    }
}