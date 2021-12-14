package com.eric.marvelapi.comics.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "creator")
data class Creator (

	@field:SerializedName("resourceURI") val resourceURI : String,
	@field:SerializedName("name") val name : String,
	@field:SerializedName("role") val role : String
)
