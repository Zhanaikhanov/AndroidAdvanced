package com.raywenderlich.android.rwandroidtutorial.todo

class TodoPresenter: ToDoContract.TodoPresenter {

    private var todoView: ToDoContract.TodoView? = null

    private val todoRepository: TodoRepository = TodoRepositoryImpl()

    override fun attachView(todoView: ToDoContract.TodoView) {
        this.todoView = todoView
    }

    override fun detachView() {
        todoView = null
    }

    override fun getTodoList() {
        val todoList = todoRepository.getTodoList()
        todoView?.showTodoList(todoList)
    }
}