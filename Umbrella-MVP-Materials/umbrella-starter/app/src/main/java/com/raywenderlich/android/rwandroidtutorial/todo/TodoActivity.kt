package com.raywenderlich.android.rwandroidtutorial.todo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.raywenderlich.android.rwandroidtutorial.R

class TodoActivity : AppCompatActivity(), ToDoContract.TodoView {

    private val presenter: TodoPresenter = TodoPresenter()

    private lateinit var todoListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        presenter.attachView(this)
        todoListRecyclerView = findViewById(R.id.todo_list_recycler_view)
        presenter.getTodoList()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun showTodoList(todoList: List<TodoViewData>) {
        todoListRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@TodoActivity)
            adapter = TodoAdapter(todoList)
        }
    }
}