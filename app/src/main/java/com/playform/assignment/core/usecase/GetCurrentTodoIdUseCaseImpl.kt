package com.playform.assignment.core.usecase

import com.playform.assignment.model.repository.TodoRepository
import com.playform.assignment.model.usecase.GetCurrentTodoIdUseCase

class GetCurrentTodoIdUseCaseImpl(private val repository: TodoRepository): GetCurrentTodoIdUseCase {
  override suspend fun getCurrentId(): Int = repository.getTodoId()
}