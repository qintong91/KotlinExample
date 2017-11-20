package com.example.qintong.kotlinexample.todaytasklist

import android.util.Log
import com.example.qintong.kotlinexample.data.Task
import com.example.qintong.kotlinexample.data.source.TasksDataSource
import com.example.qintong.kotlinexample.di.ActivityScope
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@ActivityScope
class TodayTaskListPresenter @Inject constructor(view: TodayTaskListContract.View) : TodayTaskListContract.Presenter {
    private val mView: TodayTaskListContract.View = view
    @Inject
    lateinit var mTasksRepository: TasksDataSource
    private val mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun subscribe() {
        loadTasks(true)
    }

    override fun unsubscribe() {
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
                            //processTasks(tasks)
                            Log.d("qintong", "size:"+tasks.size)
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
        mTasksRepository.completeTask(completedTask)
    }

    override fun activateTask(activeTask: Task) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearCompletedTasks() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}