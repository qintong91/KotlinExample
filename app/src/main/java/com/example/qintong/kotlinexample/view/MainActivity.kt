package com.example.qintong.kotlinexample.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.qintong.kotlinexample.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "Hello Kotlin!"
    }
}