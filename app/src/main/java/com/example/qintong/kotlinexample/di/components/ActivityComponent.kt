package com.example.qintong.kotlinexample.di.components

import com.example.qintong.kotlinexample.di.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class))
interface ActivityComponent {
}