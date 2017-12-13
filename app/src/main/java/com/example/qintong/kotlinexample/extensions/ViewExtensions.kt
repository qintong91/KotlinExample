package com.example.qintong.kotlinexample.extensions

import android.widget.EditText
import android.widget.TextView

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)


var EditText.editable: CharSequence
    get() = text
    set(v) = setText(v, TextView.BufferType.EDITABLE)