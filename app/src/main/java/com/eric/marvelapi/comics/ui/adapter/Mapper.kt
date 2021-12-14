package com.eric.marvelapi.comics.ui.adapter

import com.eric.marvelapi.comics.model.Data

private val IMAGE_VARIANT = "standard_large"
private lateinit var dataMapper: Data

object Mapper {

    fun mapper(data: Data): Data {
        dataMapper = data
        data.results.forEachIndexed { index, comic ->
            dataMapper
                .results[index]
                .thumbnail.path =
                "${comic.thumbnail.path}/$IMAGE_VARIANT.${comic.thumbnail.extension}"
        }
        return dataMapper
    }
}