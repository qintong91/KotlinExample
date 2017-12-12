package com.example.qintong.kotlinexample.di.modules

import android.app.Application
import android.content.Context
import com.example.qintong.kotlinexample.data.source.TasksDataSource
import com.example.qintong.kotlinexample.data.FakeTasksDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    internal abstract fun bindContext(application: Application): Context

    @Binds
    internal abstract fun bindDataSource(dataSource: FakeTasksDataSource) : TasksDataSource
}