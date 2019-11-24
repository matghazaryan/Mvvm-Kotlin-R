package com.mg.android.kotlin_mvvm

import android.app.Application
import com.karntrehan.posts.core.di.AppModule
import com.karntrehan.posts.core.di.CoreComponent
import com.karntrehan.posts.core.di.DaggerCoreComponent
import com.karntrehan.posts.core.networking.synk.Synk

open class MvvmKotlinRApp : Application() {

    companion object {
        lateinit var coreComponent: CoreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initSynk()
        initDI()
    }

    private fun initSynk() {
        Synk.init(this)
    }

    private fun initDI() {
        coreComponent = DaggerCoreComponent.builder().appModule(AppModule(this)).build()
    }
}