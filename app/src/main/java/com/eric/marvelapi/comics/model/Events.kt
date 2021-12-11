package com.eric.marvelapi.comics.model

data class Events (

	val available : Int,
	val collectionURI : String,
	val items : List<String>,
	val returned : Int
)
