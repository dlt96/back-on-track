package com.daniellopez.backontrack.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.daniellopez.backontrack.data.database.dao.QuoteDao
import com.daniellopez.backontrack.data.database.entity.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}