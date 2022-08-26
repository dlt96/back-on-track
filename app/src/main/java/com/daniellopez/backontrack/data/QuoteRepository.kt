package com.daniellopez.backontrack.data

import com.daniellopez.backontrack.data.model.QuoteModel
import com.daniellopez.backontrack.data.model.QuoteProvider
import com.daniellopez.backontrack.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response // acts as a small DB
        return response
    }
}