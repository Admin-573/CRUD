package com.example.crud.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.AddTask
import com.example.crud.Model.TaskListModel
import com.example.crud.R

class TaskListAdapter (tasklist : List<TaskListModel>,internal var context : Context) :
    RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>()
{
    internal var tasklist : List<TaskListModel> = ArrayList()
    init {
        this.tasklist = tasklist
    }

    inner class  TaskViewHolder(view : View) :RecyclerView.ViewHolder(view)
    {
        var name : TextView = view.findViewById(R.id.txt_name)
        var details : TextView = view.findViewById(R.id.txt_details)
        var btn_edit : Button = view.findViewById(R.id.btn_update)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_list_task,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val tasks = tasklist[position]
        holder.name.text = tasks.name
        holder.details.text = tasks.details
        holder.btn_edit.setOnClickListener{
            val i = Intent(context, AddTask::class.java)
            i.putExtra("Mode","E")
            i.putExtra("Id",tasks.id)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return tasklist.size
    }

}