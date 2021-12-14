package com.eric.marvelapi.comics.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "urls")
data class Urls (

	@field:SerializedName("type") val type : String? = null,
	@field:SerializedName("url") val url : String? = null
)
