package com.playform.assignment.core.repository.di

import com.playform.assignment.core.repository.TodoRepositoryImpl
import com.playform.assignment.model.repository.TodoRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val repoModule = Kodein.Module("repository") {
  bind<TodoRepository>() with singleton { TodoRepositoryImpl(instance(), instance()) }
}