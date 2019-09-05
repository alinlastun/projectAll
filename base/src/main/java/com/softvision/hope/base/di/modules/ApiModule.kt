package com.softvision.hope.base.di.modules

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.softvision.hope.base.BuildConfig
import com.softvision.hope.base.Config
import com.softvision.hope.base.api.CampaignService
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    internal fun provideRetrofit(): Retrofit {
        val httpClient = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(loggingInterceptor)
        }

        return Retrofit.Builder()
            .baseUrl(Config.BeUri)
            .addConverterFactory(Json.nonstrict.asConverterFactory(MediaType.get("application/json")))
            .client(httpClient.build())
            .build()
    }

    @Singleton
    @Provides
    internal fun provideCampaign(retrofit: Retrofit): CampaignService =
        retrofit.create(CampaignService::class.java)
}