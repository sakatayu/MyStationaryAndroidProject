package com.fefe.mystationaryproject.di.modules

import android.app.Application
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

//　Retrofitの設定
@Module
class NetworkModule(private var application: Application) {

    @Singleton
    @Provides
    fun provideRetrofitAdapter(moshi: Moshi? = null): Retrofit {
        return Retrofit.Builder().baseUrl("")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
    }
}