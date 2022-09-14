package com.daniellopez.backontrack.domain

import com.daniellopez.backontrack.data.QuoteRepository
import com.daniellopez.backontrack.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()//same as (0..quotes.size -1
            return quotes[randomNumber]
        }
        return null
    }
}