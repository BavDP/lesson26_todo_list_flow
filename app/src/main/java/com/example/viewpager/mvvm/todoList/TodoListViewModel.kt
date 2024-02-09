package com.example.viewpager.mvvm.todoList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.viewpager.models.todoList.TodoTask
import com.example.viewpager.models.todoList.TodoTaskState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class TodoListViewModel(private var repository: TodoListRepository = TodoListRepository()): ViewModel() {
    lateinit var todoListLiveData: LiveData<List<TodoTask>>
    var activeTodoState: TodoTaskState = TodoTaskState.NONE
        set(value) {
            field = value
            todoListLiveData = repository.loadTodoListTasksByStatus(value).flowOn(Dispatchers.IO).asLiveData()
        }
}