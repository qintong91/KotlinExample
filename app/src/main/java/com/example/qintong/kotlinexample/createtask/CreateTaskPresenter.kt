package com.example.qintong.kotlinexample.createtask

import com.example.qintong.kotlinexample.data.source.TasksDataSource
import javax.inject.Inject

class CreateTaskPresenter @Inject constructor() : CreateTaskContract.Presenter {
    lateinit var mView : CreateTaskContract.View
    @Inject
    lateinit var mTasksDataSource : TasksDataSource

    override fun takeView(view: CreateTaskContract.View) {
        mView = view
    }

    override fun dropView() {
    }

    override fun saveTask(title: String, description: String) {
        mTasksDataSource.saveTask(title, description)
        mView.onTaskCreated(title)
    }
}