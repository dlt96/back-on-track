package com.daniellopez.backontrack.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor() {
    //acts as a small DB
    var quotes: List<QuoteModel> = emptyList()
}