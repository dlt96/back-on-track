package com.daniellopez.backontrack.domain

import com.daniellopez.backontrack.data.QuoteRepository
import com.daniellopez.backontrack.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
){

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}