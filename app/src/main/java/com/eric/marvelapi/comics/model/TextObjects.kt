package com.eric.marvelapi.comics.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "text_objects")
data class TextObjects (

	@field:SerializedName("type") val type : String? = null,
	@field:SerializedName("language") val language : String? = null,
	@field:SerializedName("text") val text : String? = null
)
