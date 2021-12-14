package com.eric.marvelapi.comics.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "storie")
data class Storie (

	@field:SerializedName("resourceURI") val resourceURI : String,
	@field:SerializedName("name") val name : String,
	@field:SerializedName("type") val type : String
)
