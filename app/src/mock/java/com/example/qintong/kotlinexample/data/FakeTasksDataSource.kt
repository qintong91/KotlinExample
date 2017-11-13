package com.example.qintong.kotlinexample.data

import android.support.annotation.VisibleForTesting
import com.example.qintong.kotlinexample.data.source.TasksDataSource
import io.reactivex.Flowable


class FakeTasksDataSource: TasksDataSource {

    init {
        saveTask(Task("1","title1",System.currentTimeMillis(),"des",false))
        saveTask(Task("2","title2",System.currentTimeMillis(),"des",false))
        saveTask(Task("3","title3",System.currentTimeMillis(),"des",false))
    }

    override fun getTasks(): Flowable<List<Task>> {
        val values = TASKS_SERVICE_DATA.values
        return Flowable.fromIterable<Task>(values).toList().toFlowable()
    }

    override fun getTask( taskId: String): Flowable<Task> {
        val task = TASKS_SERVICE_DATA.get(taskId)
        return Flowable.just(task)
    }

    override fun saveTask(task: Task) {
        TASKS_SERVICE_DATA.put(task.id, task)
    }

    override fun completeTask(task: Task) {
        val completedTask = task.copy()
        TASKS_SERVICE_DATA.put(task.id, completedTask)
    }

    override fun completeTask(taskId: String) {
        val task = TASKS_SERVICE_DATA.get(taskId)
        task?.let {
            val completedTask = task.copy(isComplete = true)
            TASKS_SERVICE_DATA.put(taskId, completedTask)
        }
    }

    override fun activateTask(task: Task) {
        task?.let {
            val activeTask = task.copy(isComplete = false)
            TASKS_SERVICE_DATA.put(task.id, activeTask)
        }
    }

    override fun activateTask(taskId: String) {
        val task = TASKS_SERVICE_DATA.get(taskId)
        task?.let {
            val activeTask = task.copy(isComplete = false)
            TASKS_SERVICE_DATA.put(taskId, activeTask)
        }
    }

    override fun clearCompletedTasks() {
        val it = TASKS_SERVICE_DATA.entries.iterator()
        while (it.hasNext()) {
            val entry = it.next()
            if (entry.value.isComplete) {
                it.remove()
            }
        }
    }

    override fun refreshTasks() {
        // Not required because the {@link TasksRepository} handles the logic of refreshing the
        // tasks from all the available data sources.
    }

    override fun deleteTask(taskId: String) {
        TASKS_SERVICE_DATA.remove(taskId)
    }

    override fun deleteAllTasks() {
        TASKS_SERVICE_DATA.clear()
    }

    @VisibleForTesting
    fun addTasks(vararg tasks: Task) {
        for (task in tasks) {
            TASKS_SERVICE_DATA.put(task.id, task)
        }
    }

    companion object {

        private var INSTANCE: FakeTasksDataSource? = null

        private val TASKS_SERVICE_DATA = LinkedHashMap<String, Task>()

        val instance: FakeTasksDataSource
            get() {
                if (INSTANCE == null) {
                    INSTANCE = FakeTasksDataSource()
                }
                return INSTANCE as FakeTasksDataSource
            }
    }
}