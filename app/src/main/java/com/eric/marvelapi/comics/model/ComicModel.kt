package com.eric.marvelapi.comics.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "comic")
data class ComicModel(

    @PrimaryKey @field:SerializedName("id") val id: Int? = null,
    @field:SerializedName("digitalId") val digitalId: Int? = null,
    @field:SerializedName("title") val title: String? = null,
    @field:SerializedName("issueNumber") val issueNumber: Int? = null,
    @field:SerializedName("variantDescription") val variantDescription: String? = null,
    @field:SerializedName("description") val description: String? = null,
    @field:SerializedName("modified") val modified: String? = null,
    @field:SerializedName("isbn") val isbn: String? = null,
    @field:SerializedName("upc") val upc: String? = null,
    @field:SerializedName("diamondCode") val diamondCode: String? = null,
    @field:SerializedName("ean") val ean: String? = null,
    @field:SerializedName("issn") val issn: String? = null,
    @field:SerializedName("format") val format: String? = null,
    @field:SerializedName("pageCount") val pageCount: Int? = null,
    @field:SerializedName("resourceURI") val resourceURI: String? = null,
    @Embedded(prefix = "series_") val series: Series? = null,
    @Embedded val price: Prices? = null,
    @Embedded val thumbnail: Thumbnail? = null
)
