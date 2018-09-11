package com.alexandre.potentialgrowth.data

import android.arch.lifecycle.LiveData
import com.alexandre.potentialgrowth.db.QuoteDao
import com.alexandre.potentialgrowth.model.Quote

import com.alexandre.potentialgrowth.webservice.QuoteService
import com.alexandre.potentialgrowth.webservice.requestQuote
import java.util.*
import java.util.concurrent.Executor

class QuoteRepo(private val quoteService: QuoteService, private val quoteDao: QuoteDao, private val ioExecutor: Executor) {

    fun getQuote(): LiveData<Quote> {
        requestQuote(quoteService, {
            quoteResponse ->
            ioExecutor.execute {
                quoteDao.insert(quoteResponse.quote)
            }
        }, { error ->

        })
        return quoteDao.getTheLastQuote()
    }
}