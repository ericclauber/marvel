package com.eric.core.utils.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun providesRetrofitInstance(apiClass: Class<*>, url: String) : Any{

        var retrofit: Retrofit?

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(httpLoggingInterceptor)

        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit!!.create(apiClass)
    }

 //   fun providesCreateApi()
}