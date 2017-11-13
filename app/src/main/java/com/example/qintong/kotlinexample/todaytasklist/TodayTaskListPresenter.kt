package com.example.qintong.kotlinexample.todaytasklist

import android.util.Log
import com.example.qintong.kotlinexample.data.Task
import com.example.qintong.kotlinexample.data.FakeTasksDataSource
import com.example.qintong.kotlinexample.data.source.TasksDataSource
import io.reactivex.schedulers.Schedulers.io
import io.reactivex.Flowable
import java.util.Locale.filter
import io.reactivex.disposables.CompositeDisposable




class TodayTaskListPresenter(view: TodayTaskListContract.View) : TodayTaskListContract.Presenter {
    private val mView: TodayTaskListContract.View = view
    private val mTasksRepository: TasksDataSource  = FakeTasksDataSource.Companion.instance;
    private val mCompositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun subscribe() {
        val disposable = mTasksRepository
                .getTasks()
                .subscribe(
                        // onNext
                        { tasks ->
                            //processTasks(tasks)
                            Log.d("qintong", "size:"+tasks.size)
                            mView.showTasks(tasks)
                        })
        mCompositeDisposable?.add(disposable)
    }

    override fun dropView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun result(requestCode: Int, resultCode: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadTasks(forceUpdate: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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