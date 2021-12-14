package com.eric.marvelapi.comics.di

import android.content.Context
import androidx.room.Room
import com.eric.marvelapi.comics.db.ComicDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DB_NAME = "ComicDatabase.db"

@InstallIn(SingletonComponent::class)
@Module
class ComicDatabaseModule {

   private var comicDatabase: ComicDatabase? = null

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context) =
        comicDatabase ?: synchronized(this) {
            comicDatabase = buildDatabase(context)
        }

    private fun buildDatabase(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            ComicDatabase::class.java,
            DB_NAME
        ).build()
}