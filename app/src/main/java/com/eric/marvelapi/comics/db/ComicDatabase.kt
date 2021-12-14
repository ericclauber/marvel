package com.eric.marvelapi.comics.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eric.marvelapi.comics.model.ComicModel

@Database(
    entities = arrayOf(ComicModel::class),
    version = 1,
    exportSchema = false
)
abstract class ComicDatabase : RoomDatabase()