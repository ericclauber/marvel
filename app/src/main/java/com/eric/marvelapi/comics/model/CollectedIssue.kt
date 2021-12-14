package com.eric.marvelapi.comics.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "collected_issue")
data class CollectedIssue(
    @field:SerializedName("resourceURI") val resourceURI: String,
    @field:SerializedName("name") val name: String
)