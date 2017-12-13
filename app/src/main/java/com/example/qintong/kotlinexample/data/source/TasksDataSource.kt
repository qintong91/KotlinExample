package com.example.qintong.kotlinexample.data.source

import com.example.qintong.kotlinexample.data.Task
import io.reactivex.Flowable


interface TasksDataSource {

    fun getTasks(): Flowable<List<Task>>

    fun getTask(taskId: String): Flowable<Task>

    fun saveTask(task: Task)

    fun saveTask(name: String, description: String)

    fun completeTask(task: Task)

    fun completeTask(taskId: String)

    fun activateTask(task: Task)

    fun activateTask(taskId: String)

    fun clearCompletedTasks()

    fun refreshTasks()

    fun deleteAllTasks()

    fun deleteTask(taskId: String)
}