package com.raywenderlich.android.rwandroidtutorial.todo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.raywenderlich.android.rwandroidtutorial.R

class TodoAdapter(
        private val todoList: List<TodoViewData>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false))
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(viewHolder: TodoViewHolder, position: Int) {
        viewHolder.bindView(todoList[position])
    }

    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.title)
        private val description = view.findViewById<TextView>(R.id.description)

        fun bindView(todoViewData: TodoViewData) {
            title.text = todoViewData.title
            description.text = todoViewData.description
        }
    }
}