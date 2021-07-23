package com.playform.assignment.model.usecase

import com.playform.assignment.model.data.Result
import com.playform.assignment.model.data.Todo

interface GetTodoUseCase {
  suspend fun getTodo(id: Int): Result<Todo>
}