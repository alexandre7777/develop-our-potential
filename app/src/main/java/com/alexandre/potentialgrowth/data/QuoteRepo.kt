package com.alexandre.potentialgrowth.data

import android.app.Application
import android.arch.lifecycle.LiveData
import android.content.Context
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.db.QuoteDao
import com.alexandre.potentialgrowth.model.Quote

import com.alexandre.potentialgrowth.webservice.QuoteService
import com.alexandre.potentialgrowth.webservice.requestQuote
import java.util.*
import java.util.concurrent.Executor

class QuoteRepo(private val quoteService: QuoteService, private val quoteDao: QuoteDao, private val ioExecutor: Executor) {

    private val TIME_BETWEEN_DOWNLOAD = 60000 * 60 * 8

    fun getQuote(application: Application): LiveData<Quote> {

        val sharedPref = application.getSharedPreferences(
                application.getString(R.string.preference_file), Context.MODE_PRIVATE)

        val lastDownload = sharedPref.getLong(application.getString(R.string.preference_last_download), 0)

        if(lastDownload < Date().time - TIME_BETWEEN_DOWNLOAD) {
            requestQuote(quoteService, { quoteResponse ->
                ioExecutor.execute {
                    quoteDao.insert(quoteResponse.quote)
                    with (sharedPref.edit()) {
                        putLong(application.getString(R.string.preference_last_download), Date().time)
                        apply()
                    }
                    quoteDao.deleteQuoteByTime(Date().time - TIME_BETWEEN_DOWNLOAD)
                }
            }, { error ->

            })
        }

        return quoteDao.getTheLastQuote()
    }
}