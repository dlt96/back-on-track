package com.daniellopez.backontrack.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel(
    //todo: add mappers to domain / presentation
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String
)
