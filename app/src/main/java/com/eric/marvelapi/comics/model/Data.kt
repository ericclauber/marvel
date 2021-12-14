package com.eric.marvelapi.comics.model

data class Data (

	val offset : Int,
	val limit : Int,
	val total : Int,
	val count : Int,
	var comicList : List<ComicModel>,
	val results : List<Comic>
)
