package com.example.qintong.kotlinexample.todaytasklist

import com.example.qintong.kotlinexample.data.Task
import com.example.qintong.kotlinexample.data.source.TasksDataSource
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TodayTaskListPresenter @Inject constructor(val mTasksRepository: TasksDataSource) : TodayTaskListContract.Presenter {
    lateinit var mView: TodayTaskListContract.View
    private val mCompositeDisposable = CompositeDisposable()

    override fun takeView(view : TodayTaskListContract.View) {
        mView = view
        loadTasks(true)
    }

    override fun dropView() {
        mCompositeDisposable.clear()
    }

    override fun result(requestCode: Int, resultCode: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadTasks(forceUpdate: Boolean) {
        val disposable = mTasksRepository
                .getTasks()
                .subscribe(
                        // onNext
                        { tasks ->
                            mView.showTasks(tasks)
                        })
        mCompositeDisposable.add(disposable)
    }

    override fun addNewTask() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openTaskDetails(requestedTask: Task) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun completeTask(completedTask: Task) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun activateTask(activeTask: Task) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearCompletedTasks() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}