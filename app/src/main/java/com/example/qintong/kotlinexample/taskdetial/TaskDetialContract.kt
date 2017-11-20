package com.example.qintong.kotlinexample.taskdetial

import com.example.qintong.kotlinexample.BasePresenter
import com.example.qintong.kotlinexample.BaseView
import com.example.qintong.kotlinexample.data.Task
import com.example.qintong.kotlinexample.todaytasklist.TodayTaskListContract

interface TaskDetialContract {
    interface View : BaseView<TodayTaskListContract.Presenter> {

        val isActive: Boolean

        fun showEmptyTaskError()

        fun showTasks(list: List<Task>)

        fun setTitle(title: String)

        fun setDescription(description: String)
    }

    interface Presenter : BasePresenter<TodayTaskListContract.View> {

        fun result(requestCode: Int, resultCode: Int)

        fun loadTasks(forceUpdate: Boolean)

        fun addNewTask()

        fun openTaskDetails(requestedTask: Task)

        fun completeTask(completedTask: Task)

        fun activateTask(activeTask: Task)

        fun clearCompletedTasks()
    }
}