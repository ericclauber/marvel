package com.eric.marvelapi.comics.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.eric.marvelapi.comics.api.ComicApi
import com.eric.marvelapi.comics.db.ComicDatabase
import com.eric.marvelapi.comics.model.ComicModel
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class ComicRemoteMediator(
    private val service: Retrofit,
    private val database: ComicDatabase
) : RemoteMediator<Int, ComicModel>() {

    private var api = service.create(ComicApi::class.java)

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ComicModel>
    ): MediatorResult {

        try {
            val response = api.getComics(
                25,
                1,
                Keys.getTimeStamp(),
                Keys.getApiKey(),
                Keys.getHash()
            ).data
            val endOfPaginationReached = response.results.isEmpty()

            response.comicList = response.results.map {
                ComicModel(
                    id = it.id,
                    title = it.title,
                    thumbnail = it.thumbnail,
                    price = it.prices?.get(0)
                )
            }

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.comicDAO().clearComics()
                }
                database.comicDAO().insertAll(response.comicList)
            }
            return MediatorResult.Success(endOfPaginationReached)
        } catch (exception: IOException) {
           return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }
    }
}