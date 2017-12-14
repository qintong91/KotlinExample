package com.example.qintong.kotlinexample.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.qintong.kotlinexample.di.components.ActivityComponent
import com.example.qintong.kotlinexample.extensions.getAppComponent


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(getAppComponent().activityComponent())
    }

    abstract protected fun inject(component: ActivityComponent)
}