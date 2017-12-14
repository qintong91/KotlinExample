package com.example.qintong.kotlinexample.timer

import android.os.Bundle
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.di.components.ActivityComponent
import com.example.qintong.kotlinexample.extensions.getAppComponent
import com.example.qintong.kotlinexample.view.BaseActivity

class TimerActivity : BaseActivity(), TimerContract.View{
    //@Inject
    lateinit var mPresenter : TimerContract.Presenter

    override fun inject(component: ActivityComponent) {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAppComponent().activityComponent().inject(this)
        setContentView(R.layout.activity_timer)
        mPresenter.takeView(this)
    }

    override fun setTitle(title: String) {
    }

    override fun setCountDown(title: String) {
    }

    override fun setDescription(description: String) {
    }
}