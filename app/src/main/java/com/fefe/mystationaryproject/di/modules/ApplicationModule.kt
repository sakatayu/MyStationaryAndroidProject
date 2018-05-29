package com.fefe.mystationaryproject.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//　全体で必要なデータを扱う
@Module
class ApplicationModule(private var application: Application) {

    @Singleton
    @Provides
    fun provideApplication() : Application = application

    @Singleton
    @Provides
    fun provideContext() : Context = application.applicationContext
}