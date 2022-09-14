package com.daniellopez.backontrack.domain

import com.daniellopez.backontrack.data.QuoteRepository
import com.daniellopez.backontrack.data.database.entity.toDatabase
import com.daniellopez.backontrack.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): List<Quote> {
        val quotes: List<Quote> = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }

}