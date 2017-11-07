package com.example.qintong.kotlinexample.view

import android.os.Bundle
import com.example.qintong.kotlinexample.R

 class MainActivity : BaseActivity() {

    private var x : ArrayList<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}