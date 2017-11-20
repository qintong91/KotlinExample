package com.example.qintong.kotlinexample.di.components

import com.example.qintong.kotlinexample.MonotaskingApplication
import com.example.qintong.kotlinexample.data.source.TasksDataSource
import com.example.qintong.kotlinexample.di.modules.ActivityBindingModule
import com.example.qintong.kotlinexample.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityBindingModule::class))
interface AppComponent   {


    fun tasksDataSource(): TasksDataSource

   // override fun inject(instance: AppComponent)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: MonotaskingApplication):  Builder
        fun build(): AppComponent
    }
}