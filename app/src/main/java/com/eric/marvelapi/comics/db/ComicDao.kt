package com.eric.marvelapi.comics.db

import androidx.paging.PagingSource
import androidx.room.*
import com.eric.marvelapi.comics.model.ComicModel

@Dao
interface ComicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(comics: List<ComicModel>)

    @Query("SELECT * FROM comic")
    fun getComics() : PagingSource<Int, ComicModel>

    @Query("DELETE FROM comic")
    suspend fun clearComics()
}