package com.example.qintong.kotlinexample.di.modules

import android.app.Application
import android.content.Context
import com.example.qintong.kotlinexample.MonotaskingApplication
import com.example.qintong.kotlinexample.data.source.TasksDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class AppModule() {

    @Binds
    @Singleton
    abstract fun tasksDataSource(tasksDataSource: com.example.qintong.kotlinexample.data.FakeTasksDataSource): TasksDataSource

    @Binds
    @Singleton
    abstract fun context(application: MonotaskingApplication): Context
}
