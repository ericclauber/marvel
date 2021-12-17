package com.eric.marvelapi.comics.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "comic")
data class Comic(

    @PrimaryKey @field:SerializedName("id") val id: Int,
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
    @Embedded val textObjects: List<TextObjects>? = null,
    @field:SerializedName("resourceURI") val resourceURI: String? = null,
    @Embedded val urls: List<Urls>? = null,
    @Embedded(prefix = "series_") val series: Series? = null,
    @Embedded val variants: List<CollectedIssue>? = null,
    @Embedded val collections: List<CollectedIssue>? = null,
    @Embedded val collectedIssues: List<CollectedIssue>? = null,
    @Embedded val dates: List<Dates>? = null,
    @Embedded val prices: List<Prices>? = null,
    @Embedded val thumbnail: Thumbnail? = null,
    @Embedded val images: List<Image>? = null,
    @Embedded(prefix = "creators_") val creators: Creators? = null,
    @Embedded(prefix = "scharacters_") val characters: Characters? = null,
    @Embedded(prefix = "stories_") val stories: Stories? = null,
  //  @Embedded(prefix = "events_") val events: Events? = null
)
