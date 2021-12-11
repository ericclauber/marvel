package com.eric.marvelapi.comics.model

data class Stories (

	val available : Int,
	val collectionURI : String,
	val items : List<Storie>,
	val returned : Int
)
