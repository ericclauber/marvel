package com.eric.marvelapi.comics.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.eric.marvelapi.comics.api.ComicApi
import com.eric.marvelapi.comics.db.ComicDatabase
import com.eric.marvelapi.comics.db.ComicRemoteKeys
import com.eric.marvelapi.comics.model.ComicModel
import com.eric.marvelapi.comics.ui.adapter.Mapper
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

        val page = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKey = getRemoteKeyClosestToCurrentPosition(state)
                remoteKey?.nextKey?.minus(1) ?: INITIAL_PAGE
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                remoteKeys?.prevKey ?: return MediatorResult.Success(remoteKeys != null)
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                if (nextKey == null){
                    return MediatorResult.Success(true)
                }
                nextKey
            }
        }

        try {
            val response = Mapper.mapper(api.getComics(
                state.config.pageSize,
                page,
                Keys.getTimeStamp(),
                Keys.getApiKey(),
                Keys.getHash()
            ).data)

            val endOfPaginationReached = response.results.isEmpty()

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.comicRemoteKeysDao().clearComics()
                    database.comicDAO().clearComics()
                }
                val prevKey = if (page == INITIAL_PAGE) null else page - 1
                val nextkey = if (endOfPaginationReached) null else page + 1
                val keys = response.comicList.map {
                    ComicRemoteKeys(it.id?.toLong(), prevKey, nextkey)
                }

                database.comicRemoteKeysDao().insertAll(keys)
                database.comicDAO().insertAll(response.comicList)
            }
            return MediatorResult.Success(endOfPaginationReached)
        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, ComicModel>)
            : ComicRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.let {
                database.comicRemoteKeysDao().getRemoteKeyComicId(it.id.toLong())
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, ComicModel>)
            : ComicRemoteKeys? {
        return state.pages.firstOrNull()?.data?.firstOrNull()?.let {
            database.comicRemoteKeysDao().getRemoteKeyComicId(it.id.toLong())
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, ComicModel>)
            : ComicRemoteKeys? {
        return state.pages.lastOrNull()?.data?.lastOrNull()?.let {
            database.comicRemoteKeysDao().getRemoteKeyComicId(it.id.toLong())
        }
    }
}