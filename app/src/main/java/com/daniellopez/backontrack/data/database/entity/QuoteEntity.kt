package com.daniellopez.backontrack.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.daniellopez.backontrack.domain.model.Quote

@Entity(tableName = "quote_table")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name = "author") val author: String
)

fun Quote.toDatabase() = QuoteEntity(quote = quote, author = author)
//mappers are located at resulting class
