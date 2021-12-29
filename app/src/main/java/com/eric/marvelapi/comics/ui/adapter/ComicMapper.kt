package com.eric.marvelapi.comics.ui.adapter

import com.eric.marvelapi.comics.model.ComicModel
import com.eric.marvelapi.comics.model.Data

private val IMAGE_VARIANT = "standard_large"
private lateinit var dataMapper: Data

object ComicMapper {

    fun mapper(data: Data): Data {
        dataMapper = data
        dataMapper.comicList = dataMapper.results.map {
            it.thumbnail?.path =
            "${it.thumbnail?.path}/$IMAGE_VARIANT.${it.thumbnail?.extension}"
                .replace("http", "https")
            ComicModel(
                id = it.id,
                title = it.title,
                thumbnail = it.thumbnail,
                price = it.prices?.get(0)
            )
        }
        return dataMapper
    }
}