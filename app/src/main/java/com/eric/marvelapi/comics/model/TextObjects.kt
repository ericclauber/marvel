package com.eric.marvelapi.comics.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "text_objects")
data class TextObjects (

	@field:SerializedName("type") val type : String,
	@field:SerializedName("language") val language : String,
	@field:SerializedName("text") val text : String
)
