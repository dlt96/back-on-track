package com.daniellopez.backontrack.data

import com.daniellopez.backontrack.data.database.dao.QuoteDao
import com.daniellopez.backontrack.data.database.entity.QuoteEntity
import com.daniellopez.backontrack.data.model.QuoteModel
import com.daniellopez.backontrack.data.network.QuoteService
import com.daniellopez.backontrack.domain.model.Quote
import com.daniellopez.backontrack.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao

) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}