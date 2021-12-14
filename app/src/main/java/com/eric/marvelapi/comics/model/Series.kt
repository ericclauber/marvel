package com.eric.marvelapi.comics.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "series")
data class Series (

	@field:SerializedName("resourceURI") val resourceURI : String,
	@field:SerializedName("name") val name : String
)
