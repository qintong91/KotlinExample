package com.example.qintong.kotlinexample.tasklist

import com.example.qintong.kotlinexample.BasePresenter
import com.example.qintong.kotlinexample.BaseView



interface TaskListContract {
    interface View : BaseView<Presenter> {

        val isActive: Boolean

        fun showEmptyTaskError()

        fun showTasksList()

        fun setTitle(title: String)

        fun setDescription(description: String)
    }

    interface Presenter : BasePresenter<View> {

        val isDataMissing: Boolean

        fun saveTask(title: String, description: String)

        fun populateTask()
    }
}