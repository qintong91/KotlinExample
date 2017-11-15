package com.example.qintong.kotlinexample.createtask

import android.os.Bundle
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.view.BaseActivity

class CreateTaskActvity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)
        setFinishOnTouchOutside(true)
    }
}