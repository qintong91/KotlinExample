package com.example.qintong.kotlinexample.di.modules

import com.example.qintong.kotlinexample.di.ActivityScope
import com.example.qintong.kotlinexample.navigation.NavigationActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {


    @ActivityScope
    @ContributesAndroidInjector
    abstract fun provideMainActivityInjector(): NavigationActivity
}
