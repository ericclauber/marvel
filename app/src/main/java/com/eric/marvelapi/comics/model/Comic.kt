package com.eric.marvelapi.comics.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "comic")
data class Comic(

    @PrimaryKey @field:SerializedName("id") val id: Int,
    @field:SerializedName("digitalId") val digitalId: Int,
    @field:SerializedName("title") val title: String,
    @field:SerializedName("issueNumber") val issueNumber: Int,
    @field:SerializedName("variantDescription") val variantDescription: String,
    @field:SerializedName("description") val description: String,
    @field:SerializedName("modified") val modified: String,
    @field:SerializedName("isbn") val isbn: String,
    @field:SerializedName("upc") val upc: String,
    @field:SerializedName("diamondCode") val diamondCode: String,
    @field:SerializedName("ean") val ean: String,
    @field:SerializedName("issn") val issn: String,
    @field:SerializedName("format") val format: String,
    @field:SerializedName("pageCount") val pageCount: Int,
    @Embedded val textObjects: List<TextObjects>,
    @field:SerializedName("resourceURI") val resourceURI: String,
    @Embedded val urls: List<Urls>,
    @Embedded(prefix = "series_") val series: Series,
    @Embedded val variants: List<CollectedIssue>,
    @Embedded val collections: List<CollectedIssue>,
    @Embedded val collectedIssues: List<CollectedIssue>,
    @Embedded val dates: List<Dates>,
    @Embedded val prices: List<Prices>,
    @Embedded val thumbnail: Thumbnail,
    @Embedded val images: List<Image>,
    @Embedded(prefix = "creators_") val creators: Creators,
    @Embedded(prefix = "scharacters_") val characters: Characters,
    @Embedded(prefix = "stories_") val stories: Stories,
    @Embedded(prefix = "events_") val events: Events
)
