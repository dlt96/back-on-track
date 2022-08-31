package com.daniellopez.backontrack.data

import com.daniellopez.backontrack.data.model.QuoteModel
import com.daniellopez.backontrack.data.model.QuoteProvider
import com.daniellopez.backontrack.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
) {

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        quoteProvider.quotes = response // acts as a small DB
        return response
    }
}