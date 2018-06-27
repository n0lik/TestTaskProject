package com.test.testtaskproject.di.modules

import com.test.testtaskproject.BuildConfig
import com.test.testtaskproject.network.ServerApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideBaseUrl(): String = BuildConfig.BASE_END_POINT

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideAdapterFactory() = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideConverterFactory() = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(url: String,
                        client: OkHttpClient,
                        adapterFactory: RxJava2CallAdapterFactory,
                        converterFactory: GsonConverterFactory): Retrofit =
            Retrofit.Builder()
                    .baseUrl(url)
                    .client(client)
                    .addCallAdapterFactory(adapterFactory)
                    .addConverterFactory(converterFactory)
                    .build()

    @Provides
    @Singleton
    fun provideServerApi(retrofit: Retrofit): ServerApi = retrofit.create(ServerApi::class.java)

}