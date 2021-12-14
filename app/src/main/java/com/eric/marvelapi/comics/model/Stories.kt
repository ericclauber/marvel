package com.eric.marvelapi.comics.model

import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "stories")
data class Stories (

	@field:SerializedName("available") val available : Int? = null,
	@field:SerializedName("collectionURI") val collectionURI : String? = null,
	@Embedded val items : List<Storie>? = null,
	@field:SerializedName("returned") val returned : Int? = null
)
