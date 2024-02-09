package com.example.viewpager.mvvm.todoList

import com.example.viewpager.models.todoList.TodoTask
import com.example.viewpager.models.todoList.TodoTaskDB
import com.example.viewpager.models.todoList.TodoTaskState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TodoListRepository {
    fun loadTodoListTasksByStatus(status: TodoTaskState): Flow<List<TodoTask>> {
        return flow {
            while(true) {
                emit(TodoTaskDB.tasks().filter { task -> task.status == status })
                delay(5000)
            }
        }
    }
}