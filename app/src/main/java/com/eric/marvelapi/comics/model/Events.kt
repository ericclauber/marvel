package com.eric.marvelapi.comics.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "events")
data class Events (

	@field:SerializedName("available") val available : Int? = null,
	@field:SerializedName("collectionURI") val collectionURI : String? = null,
	@field:SerializedName("items") val items : List<String> = arrayListOf(),
	@field:SerializedName("returned") val returned : Int? = null
)
