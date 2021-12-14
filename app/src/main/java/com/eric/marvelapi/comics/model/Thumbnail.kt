package com.eric.marvelapi.comics.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "thumbnail")
data class Thumbnail(

    @field:SerializedName("path") var path: String? = null,
    @field:SerializedName("extension") val extension: String? = null
)
