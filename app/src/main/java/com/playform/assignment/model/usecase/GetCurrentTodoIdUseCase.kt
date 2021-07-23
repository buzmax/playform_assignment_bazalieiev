package com.playform.assignment.model.usecase

interface GetCurrentTodoIdUseCase {
  suspend fun getCurrentId(): Int
}