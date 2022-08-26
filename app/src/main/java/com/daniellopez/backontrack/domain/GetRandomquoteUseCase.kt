package com.daniellopez.backontrack.domain

import com.daniellopez.backontrack.data.QuoteRepository
import com.daniellopez.backontrack.data.model.QuoteModel
import com.daniellopez.backontrack.data.model.QuoteProvider

class GetRandomquoteUseCase {
    private val repository = QuoteRepository()

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes //todo: use repository
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()//same as (0..quotes.size -1
            return quotes[randomNumber]
        }
        return null
    }
}