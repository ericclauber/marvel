package com.eric.marvelapi.comics.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comic_remote_keys")
data class ComicRemoteKeys(
    @PrimaryKey
    val comicId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
