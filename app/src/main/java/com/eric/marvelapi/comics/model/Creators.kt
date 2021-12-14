package com.eric.marvelapi.comics.model

import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "creators")
data class Creators (
	@field:SerializedName("available") val available : Int,
	@field:SerializedName("collectionURI") val collectionURI : String,
	@Embedded val items : List<Creator>,
	@field:SerializedName("returned") val returned : Int
)
