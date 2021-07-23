package com.playform.assignment.core.usecase

import com.playform.assignment.model.data.Result
import com.playform.assignment.model.data.Todo
import com.playform.assignment.model.repository.TodoRepository
import com.playform.assignment.model.usecase.GetTodoUseCase

class GetTodoUseCaseImpl(private val repository: TodoRepository) : GetTodoUseCase {

  override suspend fun getTodo(id: Int): Result<Todo> = repository.getTodo(id)
}