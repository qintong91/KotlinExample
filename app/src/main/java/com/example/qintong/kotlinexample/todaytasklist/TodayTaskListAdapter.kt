package com.example.qintong.kotlinexample.todaytasklist

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.data.Task
import kotlin.properties.Delegates

class TodayTaskListAdapter : RecyclerView.Adapter<TodayTaskListAdapter.TaskViewHolder>() {
    var tasksList: List<Task> by Delegates.observable(listOf()) {
        prop, old, new ->
        Log.d("qintong", "change change change")
        notifyDataSetChanged()
        Log.d("qintong", "change change change222")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TaskViewHolder {
        Log.d("qintong", "onCreateViewHolder:" + viewType)
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent,
                false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        Log.d("qintong", "onBindViewHolder:" + position)
        holder.name.setText(tasksList[position].title)
    }

    override fun getItemCount(): Int {
        Log.d("qintong", "getItemCount:" + tasksList.size)
        return tasksList.size
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name by lazy {
            itemView.findViewById<TextView>(R.id.name)
        }

    }

    override fun getItemViewType(position: Int): Int {
        Log.d("qintong", "getItemViewType:" + position)
        return 1
    }

}