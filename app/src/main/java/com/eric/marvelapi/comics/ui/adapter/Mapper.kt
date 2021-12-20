package com.eric.marvelapi.comics.ui.adapter

import com.eric.marvelapi.comics.model.ComicModel
import com.eric.marvelapi.comics.model.Data

private val IMAGE_VARIANT = "standard_large"
private lateinit var dataMapper: Data

object Mapper {

    fun mapper(data: Data): Data {
        dataMapper = data
        data.results.forEachIndexed { index, comic ->
            dataMapper
                .results[index]
                .thumbnail?.path =
                "${comic.thumbnail?.path}/$IMAGE_VARIANT.${comic.thumbnail?.extension}"
                    .replace("http", "https")
        }
        dataMapper.comicList = dataMapper.results.map {

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