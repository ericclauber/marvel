package com.eric.marvelapi.comics.api

import com.eric.marvelapi.comics.model.Data

data class Response (

	val code : Int,
	val status : String,
	val copyright : String,
	val attributionText : String,
	val attributionHTML : String,
	val etag : String,
	val data : Data
)
