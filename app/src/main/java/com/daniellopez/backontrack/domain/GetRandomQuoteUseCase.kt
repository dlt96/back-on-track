package com.daniellopez.backontrack.domain

import com.daniellopez.backontrack.data.model.QuoteModel
import com.daniellopez.backontrack.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider){

    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes //todo: use repository
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()//same as (0..quotes.size -1
            return quotes[randomNumber]
        }
        return null
    }
}