package com.alexandre.potentialgrowth.model

data class QuoteResponse(
        val qotd_date: String = "",
        val quote: Quote = Quote()
)