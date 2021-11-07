package com.raywenderlich.android.rwandroidtutorial.todo

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class TodoRepositoryImpl: TodoRepository {

    private val todoListJson = "[{\"title\": \"work\",\"description\": \"add new page to web\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" },{\"title\": \"lesson\",\"description\": \"HW1\" }]"

    override fun getTodoList(): List<TodoViewData> {
        val moshi = Moshi.Builder().build()
        val listOfTodoViewDataType: Type = Types.newParameterizedType(List::class.java, TodoViewData::class.java)
        val jsonAdapter: JsonAdapter<List<TodoViewData>> = moshi.adapter(listOfTodoViewDataType)

        return jsonAdapter.fromJson(todoListJson)
    }
}