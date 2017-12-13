package com.example.qintong.kotlinexample.di.components

import com.example.qintong.kotlinexample.createtask.CreateTaskActivity
import com.example.qintong.kotlinexample.di.PerActivity
import com.example.qintong.kotlinexample.di.modules.ActivityModule
import com.example.qintong.kotlinexample.view.MainActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent (modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject (activity: MainActivity)
    fun inject (activity: CreateTaskActivity)
}