package com.example.qintong.kotlinexample

import android.app.Application
import com.example.qintong.kotlinexample.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import com.example.qintong.kotlinexample.di.components.AppComponent




class MonotaskingApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}