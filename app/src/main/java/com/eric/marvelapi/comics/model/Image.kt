package com.eric.marvelapi.comics.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "image")
class Image(
    @field:SerializedName("path") var path: String,
    @field:SerializedName("extension") val extension: String
)