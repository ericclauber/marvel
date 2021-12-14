package com.eric.marvelapi.comics.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "dates")
data class Dates (

	@field:SerializedName("type") val type : String? = null,
	@field:SerializedName("date") val date : String? = null
)
