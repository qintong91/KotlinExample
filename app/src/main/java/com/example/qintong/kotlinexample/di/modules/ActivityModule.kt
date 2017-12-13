package com.example.qintong.kotlinexample.di.modules

import com.example.qintong.kotlinexample.createtask.CreateTaskContract
import com.example.qintong.kotlinexample.createtask.CreateTaskPresenter
import com.example.qintong.kotlinexample.todaytasklist.TodayTaskListContract
import com.example.qintong.kotlinexample.todaytasklist.TodayTaskListPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ActivityModule {

    @Binds
    internal abstract fun bindTodayTaskListPresenter(presenter : TodayTaskListPresenter): TodayTaskListContract.Presenter

    @Binds
    internal abstract fun bindCreateTaskPresenter(presenter : CreateTaskPresenter): CreateTaskContract.Presenter
}