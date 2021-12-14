package com.eric.marvelapi.comics.model

import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
data class Characters (

	@field:SerializedName("available") val available : Int,
	@field:SerializedName("collectionURI") val collectionURI : String,
	@Embedded val items : List<Character>,
	@field:SerializedName("returned") val returned : Int
)
