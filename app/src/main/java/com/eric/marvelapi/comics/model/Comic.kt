package com.eric.marvelapi.comics.model

data class Comic(

    val id: Int,
    val digitalId: Int,
    val title: String,
    val issueNumber: Int,
    val variantDescription: String,
    val description: String,
    val modified: String,
    val isbn: String,
    val upc: String,
    val diamondCode: String,
    val ean: String,
    val issn: String,
    val format: String,
    val pageCount: Int,
    val textObjects: List<TextObjects>,
    val resourceURI: String,
    val urls: List<Urls>,
    val series: Series,
    val variants: List<CollectedIssue>,
    val collections: List<CollectedIssue>,
    val collectedIssues: List<CollectedIssue>,
    val dates: List<Dates>,
    val prices: List<Prices>,
    val thumbnail: Thumbnail,
    val images: List<Image>,
    val creators: Creators,
    val characters: Characters,
    val stories: Stories,
    val events: Events
)
