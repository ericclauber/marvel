package com.eric.marvelapi.comics.ui

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder {

    companion object {
        fun createAPI(domain: String, apiClass: Class<*>): Any {

            var retrofit: Retrofit?

            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient
                .Builder()
                .readTimeout(15, TimeUnit.SECONDS)
            okHttpClient.addInterceptor(httpLoggingInterceptor)

            retrofit = Retrofit.Builder()
                .baseUrl(domain)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(apiClass)
        }
    }
}