package com.raywenderlich.android.rwandroidtutorial.todo

interface ToDoContract {

    interface TodoView {
        fun showTodoList(todoList: List<TodoViewData>)
    }

    interface TodoPresenter {
        fun attachView(todoView: TodoView)
        fun detachView()
        fun getTodoList()
    }
}