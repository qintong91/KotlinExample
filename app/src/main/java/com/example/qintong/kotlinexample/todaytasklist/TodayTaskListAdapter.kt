package com.example.qintong.kotlinexample.todaytasklist

import android.support.v7.widget.RecyclerView
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
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent,
                false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.name.setText(tasksList[position].title)
    }

    override fun getItemCount(): Int {
        return tasksList.size
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name by lazy {
            itemView.findViewById<TextView>(R.id.name)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return 1
    }

}