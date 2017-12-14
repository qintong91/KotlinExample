package com.example.qintong.kotlinexample.createtask

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.di.components.ActivityComponent
import com.example.qintong.kotlinexample.extensions.editable
import com.example.qintong.kotlinexample.extensions.getAppComponent
import com.example.qintong.kotlinexample.view.BaseActivity
import kotlinx.android.synthetic.main.activity_create_task.*
import javax.inject.Inject

class CreateTaskActivity : BaseActivity(), CreateTaskContract.View {

    @Inject
    lateinit var mPresenter : CreateTaskContract.Presenter

    override fun inject(component: ActivityComponent) {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAppComponent().activityComponent().inject(this)
        setContentView(R.layout.activity_create_task)
        setFinishOnTouchOutside(true)
        mPresenter.takeView(this)
        create.setOnClickListener  {
            Log.d("CreateTaskActivity","Click")
            mPresenter.saveTask(name.editable.toString(), description.editable.toString())
        }
    }

    override fun onDestroy() {
        mPresenter.dropView()
        super.onDestroy()
    }

    override fun setTitle(s: String) {
        name.editable = s
    }

    override fun setDescription(s: String) {
        description.editable = s
    }

    override fun onTaskCreated(title: String) {
        Toast.makeText(this, "创建成功", Toast.LENGTH_SHORT).show()
        finish()
    }
}