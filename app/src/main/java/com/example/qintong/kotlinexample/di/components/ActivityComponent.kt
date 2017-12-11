package com.example.qintong.kotlinexample.di.components

import com.example.qintong.kotlinexample.di.PerActivity
import com.example.qintong.kotlinexample.di.modules.ActivityModule
import dagger.Subcomponent

@PerActivity
@Subcomponent (modules =arrayOf (ActivityModule::class))
interface ActivityComponent {

}