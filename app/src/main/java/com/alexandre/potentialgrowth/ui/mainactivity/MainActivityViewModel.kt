package com.alexandre.potentialgrowth.ui.mainactivity

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.alexandre.potentialgrowth.data.QuoteRepo

class MainActivityViewModel(private val quoteRepo: QuoteRepo, application: Application) : AndroidViewModel(application) {

    var quote = quoteRepo.getQuote(application)
}