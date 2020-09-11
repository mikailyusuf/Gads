package com.mikail.gadslearnerboard.api.google

import com.mikail.gadslearnerboard.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object GoogleFormsRetrofitBuilder {

    private const val URL = "https://docs.google.com/forms/d/e/"

    private val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logger)
        .connectTimeout(120, TimeUnit.SECONDS) //Backend is really slow
        .writeTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .build()

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val apiService: GoogleApi = getRetrofit()
        .create(
            GoogleApi::class.java)
}