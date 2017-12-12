package com.example.qintong.kotlinexample.di.components

import com.example.qintong.kotlinexample.TaskApplication
import com.example.qintong.kotlinexample.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    // override fun inject(instance: AppComponent)

    fun activityComponent(): ActivityComponent

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TaskApplication): Builder
        fun build(): AppComponent
    }
}