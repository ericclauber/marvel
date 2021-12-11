package com.eric.marvelapi.comics.model

data class Creators (
	val available : Int,
	val collectionURI : String,
	val items : List<Creator>,
	val returned : Int
)
