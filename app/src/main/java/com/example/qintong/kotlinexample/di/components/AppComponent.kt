package com.example.qintong.kotlinexample.di.components

import com.example.qintong.kotlinexample.TaskApplication
import com.example.qintong.kotlinexample.di.modules.AppModule
import com.example.qintong.kotlinexample.todaytasklist.TodayTaskListPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    // override fun inject(instance: AppComponent)

    fun inject (presenter : TodayTaskListPresenter)
    fun plus(): ActivityComponent

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TaskApplication): Builder

        fun build(): AppComponent
    }
}