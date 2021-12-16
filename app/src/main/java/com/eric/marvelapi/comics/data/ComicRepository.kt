package com.eric.marvelapi.comics.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.eric.marvelapi.comics.api.ComicApi
import com.eric.marvelapi.comics.db.ComicDao
import com.eric.marvelapi.comics.db.ComicDatabase
import com.eric.marvelapi.comics.model.ComicModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import javax.inject.Inject

private const val PAGE_SIZE = 25
const val INITIAL_PAGE = 1

class ComicRepository @Inject constructor(
    private val service: Retrofit,
    private val database: ComicDatabase
) {

    private val api = service.create(ComicApi::class.java)

    @OptIn(ExperimentalPagingApi::class)
    fun getComics(): Flow<PagingData<ComicModel>> {

        val pagingSourceFactory = { database.comicDAO().getComics() }

        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(
                PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = ComicRemoteMediator(
                service,
                database
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

//    fun getComics(): Flow<Data> {
//
//        return flow {
//            emit(
//                Mapper.mapper(
//                    api.getComics(
//                        25,
//                        1,
//                        Keys.getTimeStamp(),
//                        Keys.getApiKey(),
//                        Keys.getHash()
//                    ).data
//                )
//            )
//        }
//    }
}