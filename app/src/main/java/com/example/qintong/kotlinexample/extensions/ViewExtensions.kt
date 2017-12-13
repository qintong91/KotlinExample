package com.example.qintong.kotlinexample.extensions

import android.widget.TextView

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)


var TextView.text: CharSequence
    get() = text
    set(v) = setText(v, TextView.BufferType.EDITABLE)