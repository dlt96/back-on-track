package com.daniellopez.backontrack.model

class QuoteProvider {
    companion object {//static

        fun random(): QuoteModel {
            val position = (0..3).random()
            return quote[position]
        }

        private val quote = listOf<QuoteModel>(
            QuoteModel(
                quote = "It's not a bug. It's a feature",
                author = "Anonymous"
            ),
            QuoteModel(
                quote = "Software Developer - An organism that turns caffeine into software",
                author = "Angela"
            ),
            QuoteModel(
                quote = "Today was a good day",
                author = "Ice Cube"
            ),
            QuoteModel(
                quote = "Woof Woof",
                author = "Kobe"
            ),
        )
    }
}