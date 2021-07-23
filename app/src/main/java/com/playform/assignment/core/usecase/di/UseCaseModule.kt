package com.playform.assignment.core.usecase.di

import com.playform.assignment.core.usecase.GetCurrentTodoIdUseCaseImpl
import com.playform.assignment.core.usecase.GetTodoUseCaseImpl
import com.playform.assignment.model.usecase.GetCurrentTodoIdUseCase
import com.playform.assignment.model.usecase.GetTodoUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val useCaseModule = Kodein.Module("use_case") {
  bind<GetTodoUseCase>() with singleton { GetTodoUseCaseImpl(instance()) }
  bind<GetCurrentTodoIdUseCase>() with singleton { GetCurrentTodoIdUseCaseImpl(instance()) }
}