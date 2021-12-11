package com.eric.marvelapi.comics.model

data class Characters (

	val available : Int,
	val collectionURI : String,
	val items : List<Character>,
	val returned : Int
)
