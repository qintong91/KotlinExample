package com.example.qintong.kotlinexample

import android.app.Application
import com.example.qintong.kotlinexample.di.components.AppComponent
import com.example.qintong.kotlinexample.di.components.DaggerAppComponent

class TaskApplication : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
    }
}