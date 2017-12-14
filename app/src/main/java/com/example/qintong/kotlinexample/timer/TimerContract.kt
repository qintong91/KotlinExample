package com.example.qintong.kotlinexample.timer

import com.example.qintong.kotlinexample.BasePresenter
import com.example.qintong.kotlinexample.view.BaseView

interface TimerContract {
    interface View : BaseView {
        fun setTitle(title: String)

        fun setDescription(description: String)

        fun setCountDown(title: String)
    }

    interface Presenter : BasePresenter<View> {
        fun result(requestCode: Int, resultCode: Int)

        fun startCountDown()

        fun cancelCountDown()
    }
}