package com.eric.marvelapi.comics.model

import androidx.room.Entity

data class Data (

	val offset : Int,
	val limit : Int,
	val total : Int,
	val count : Int,
	val results : List<Comic>
)
