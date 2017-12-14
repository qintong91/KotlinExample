package com.example.qintong.kotlinexample.todaytasklist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.data.Task
import kotlin.properties.Delegates

class TodayTaskListAdapter (val mOnItemClickListener : OnItemClickListener)
    : RecyclerView.Adapter<TodayTaskListAdapter.TaskViewHolder>() {
    var tasksList: List<Task> by Delegates.observable(listOf()) {
        _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent,
                false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.name.text = tasksList[position].title
    }

    override fun getItemCount(): Int {
        return tasksList.size
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        override fun onClick(v: View?) {
            mOnItemClickListener.onClick(tasksList[adapterPosition])
        }

        val name by lazy {
            itemView.findViewById<TextView>(R.id.name)
        }

        init {
            itemView.setOnClickListener(this)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return 1
    }

    interface OnItemClickListener {
        fun onClick(task : Task)
    }

}