package com.alexandre.potentialgrowth.webservice

import android.util.Log
import com.alexandre.potentialgrowth.BuildConfig
import com.alexandre.potentialgrowth.model.QuoteResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val TAG = "QuoteService"

/**
 * Get all the books
 */
fun requestQuote(
        service: QuoteService,
        onSuccess: (quoteResponse: QuoteResponse) -> Unit,
        onError: (error: String) -> Unit) {

    service.getBooks().enqueue(
            object : Callback<QuoteResponse> {
                override fun onFailure(call: Call<QuoteResponse>?, t: Throwable) {
                    Log.e(TAG, "fail to get data", t)
                    onError(t.message ?: "unknown error")
                }

                override fun onResponse(
                        call: Call<QuoteResponse>?,
                        response: Response<QuoteResponse>
                ) {
                    Log.d(TAG, "got a response $response")
                    if (response.isSuccessful) {
                        val quoteResponse = response.body() ?: QuoteResponse()
                        onSuccess(quoteResponse)
                    } else {
                        onError(response.errorBody()?.string() ?: "Unknown error")
                    }
                }
            }
    )
}

interface QuoteService{

    /**
     * Get repos ordered by stars.
     */
    @GET("api/qotd")
    fun getBooks(): Call<QuoteResponse>

    companion object {
        private const val BASE_URL = BuildConfig.SERVER_URL

        fun create(): QuoteService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(QuoteService::class.java)
        }
    }
}