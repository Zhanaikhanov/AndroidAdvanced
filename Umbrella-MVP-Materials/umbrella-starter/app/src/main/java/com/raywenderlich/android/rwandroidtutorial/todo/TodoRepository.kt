package com.raywenderlich.android.rwandroidtutorial.todo

interface TodoRepository {
    fun getTodoList(): List<TodoViewData>
}