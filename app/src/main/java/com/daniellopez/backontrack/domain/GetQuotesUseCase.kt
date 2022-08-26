package com.daniellopez.backontrack.domain

import com.daniellopez.backontrack.data.QuoteRepository
import com.daniellopez.backontrack.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? =
        repository.getAllQuotes()

}