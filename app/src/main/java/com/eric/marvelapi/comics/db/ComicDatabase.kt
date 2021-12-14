package com.eric.marvelapi.comics.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eric.marvelapi.comics.model.Comic

@Database(
    entities = arrayOf(Comic::class),
    version = 1,
    exportSchema = false
)
abstract class ComicDatabase : RoomDatabase()