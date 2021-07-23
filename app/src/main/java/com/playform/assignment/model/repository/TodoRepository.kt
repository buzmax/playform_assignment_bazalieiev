package com.playform.assignment.model.repository

import com.playform.assignment.model.data.Result
import com.playform.assignment.model.data.Todo

interface TodoRepository {
  suspend fun getTodo(id: Int): Result<Todo>
  suspend fun getTodoId(): Int
}