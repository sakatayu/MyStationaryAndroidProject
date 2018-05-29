package com.fefe.mystationaryproject.di.components

import android.app.Application
import android.content.Context
import com.fefe.mystationaryproject.MyApplication
import com.fefe.mystationaryproject.di.modules.ApiModule
import com.fefe.mystationaryproject.di.modules.ApplicationModule
import com.fefe.mystationaryproject.di.modules.LogicModule
import com.fefe.mystationaryproject.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

//　各画面に必要なModuleを配る
@Singleton
@Component(
        modules = [
            ApplicationModule::class,
            NetworkModule::class,
            ApiModule::class,
            LogicModule::class
        ])
interface ApplicationComponent {
    companion object {
//        TODO: 要変更
        fun from(application: MyApplication) = application.applicationComponent
        fun from(application: Application) = from(application as MyApplication)
        fun from(context: Context) = from(context.applicationContext as MyApplication)
    }
}