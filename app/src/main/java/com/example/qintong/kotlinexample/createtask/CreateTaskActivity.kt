package com.example.qintong.kotlinexample.createtask

import android.os.Bundle
import android.util.Log
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.view.BaseActivity
import kotlinx.android.synthetic.main.activity_create_task.*

class CreateTaskActivity : BaseActivity(), CreateTaskContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)
        setFinishOnTouchOutside(true)
        create.setOnClickListener  {
            Log.d("CreateTaskActivity","6666")
        }
    }

    override fun setTitle(s: String) {
        name.text = s
    }

    override fun setDescription(string: String) {
        description.text = string
    }
}