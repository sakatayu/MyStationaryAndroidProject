package com.fefe.mystationaryproject

import android.support.multidex.MultiDexApplication
import com.fefe.mystationaryproject.di.components.ApplicationComponent
import com.fefe.mystationaryproject.di.components.DaggerApplicationComponent
import com.fefe.mystationaryproject.di.modules.ApplicationModule
import com.fefe.mystationaryproject.di.modules.NetworkModule
import io.realm.Realm

// TODO: 名前の変更
class MyApplication : MultiDexApplication(){
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule(this))
                .build()
        Realm.init(this)
    }
}