package com.alexandre.potentialgrowth.ui.mainactivity

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexandre.potentialgrowth.data.QuoteRepo

class ViewModelFactoryMainActivity(private val quoteRepo: QuoteRepo, private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainActivityViewModel(quoteRepo, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") as Throwable
    }
}