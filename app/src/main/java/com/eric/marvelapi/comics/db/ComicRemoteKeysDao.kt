package com.eric.marvelapi.comics.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ComicRemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(keys: List<ComicRemoteKeys>)

    @Query("SELECT * FROM comic_remote_keys WHERE comicId = :comicId")
    suspend fun getRemoteKeyComicId(comicId: Long) : ComicRemoteKeys

    @Query("DELETE FROM comic_remote_keys")
    suspend fun clearComics()
}