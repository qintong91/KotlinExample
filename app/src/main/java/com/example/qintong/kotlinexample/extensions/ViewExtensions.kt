package com.example.qintong.kotlinexample.extensions

import android.widget.TextView

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)
