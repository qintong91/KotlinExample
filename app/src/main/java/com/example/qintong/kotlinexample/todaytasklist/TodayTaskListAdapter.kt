package com.example.qintong.kotlinexample.todaytasklist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.data.Task
import com.example.qintong.kotlinexample.di.ActivityScope
import kotlin.properties.Delegates

@ActivityScope
class TodayTaskListAdapter(val itemClick: (Task) -> Unit, val itemdoneClick: (Task) -> Unit)
    : RecyclerView.Adapter<TodayTaskListAdapter.TaskViewHolder>() {
    var tasksList: List<Task> by Delegates.observable(listOf()) {
        prop, old, new ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent,
                false)
        return TaskViewHolder(itemView, itemClick, itemdoneClick)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindTask(tasksList[position])
    }

    override fun getItemCount(): Int {
        return tasksList.size
    }

    class TaskViewHolder(itemView: View,private val itemClick: (Task) -> Unit, private val doneClick: (Task) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val name by lazy {
            itemView.findViewById<TextView>(R.id.name)
        }
        val done by lazy {
            itemView.findViewById<ImageView>(R.id.done)
        }

        fun bindTask(task: Task) {
            with(task) {
                name.text = title
                itemView.setOnClickListener {itemClick(this)}
                done.setOnClickListener{doneClick(this)}
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 1
    }

}