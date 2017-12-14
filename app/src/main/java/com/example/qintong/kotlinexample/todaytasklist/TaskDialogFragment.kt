package com.example.qintong.kotlinexample.todaytasklist

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import com.example.qintong.kotlinexample.data.Task

class TaskDialogFragment(val task: Task, val mDialogItemsListener: DialogItemsListener) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(context)
                .setTitle(task.title)
                //.setMessage("6666")
                .setItems(arrayOf("开始","查看","完成"), {
                    dialog, which ->
                    when (which) {
                        0 -> mDialogItemsListener.onTaskStart(task)
                        1 -> mDialogItemsListener.onViewTaskDetail(task)
                        2 -> mDialogItemsListener.onCompeteTask(task)
                    }
                    Log.d("qintong","which:"+which)
                }
                )
        return builder.create()
    }

    interface DialogItemsListener {
        fun onTaskStart(task: Task)
        fun onViewTaskDetail(task: Task)
        fun onCompeteTask(task: Task)
    }
}