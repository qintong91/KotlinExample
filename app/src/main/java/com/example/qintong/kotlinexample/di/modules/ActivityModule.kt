package com.example.qintong.kotlinexample.di.modules

import com.example.qintong.kotlinexample.todaytasklist.TodayTaskListContract
import com.example.qintong.kotlinexample.todaytasklist.TodayTaskListPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ActivityModule {

    @Binds
    internal abstract fun bindTodayTaskListPresenter(presenter : TodayTaskListPresenter): TodayTaskListContract.Presenter
}