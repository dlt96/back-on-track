package com.daniellopez.backontrack.domain.model

import com.daniellopez.backontrack.data.database.entity.QuoteEntity
import com.daniellopez.backontrack.data.model.QuoteModel

data class Quote(
    val quote: String,
    val author: String
)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)