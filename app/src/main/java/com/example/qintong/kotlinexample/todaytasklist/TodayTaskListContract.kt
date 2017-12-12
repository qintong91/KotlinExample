package com.example.qintong.kotlinexample.todaytasklist

import com.example.qintong.kotlinexample.BasePresenter
import com.example.qintong.kotlinexample.data.Task
import com.example.qintong.kotlinexample.view.BaseView


interface TodayTaskListContract {
    interface View : BaseView<Presenter> {

        val isActive: Boolean

        fun showEmptyTaskError()

        fun showTasks(list: List<Task>)

        fun setTitle(title: String)

        fun setDescription(description: String)
    }

    interface Presenter : BasePresenter<View> {

        fun result(requestCode: Int, resultCode: Int)

        fun loadTasks(forceUpdate: Boolean)

        fun addNewTask()

        fun openTaskDetails(requestedTask: Task)

        fun completeTask(completedTask: Task)

        fun activateTask(activeTask: Task)

        fun clearCompletedTasks()
    }
}