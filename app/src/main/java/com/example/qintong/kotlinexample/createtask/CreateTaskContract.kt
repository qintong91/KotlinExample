package com.example.qintong.kotlinexample.createtask

import com.example.qintong.kotlinexample.BasePresenter
import com.example.qintong.kotlinexample.view.BaseView

interface CreateTaskContract {
    interface View : BaseView<Presenter> {

        fun setTitle(title: String)

        fun setDescription(description: String)
    }

    interface Presenter : BasePresenter<View> {

        fun saveTask(title : String, description: String)

    }
}