package com.playform.assignment.core.util.di

import androidx.lifecycle.ViewModelProvider
import com.playform.assignment.core.util.ViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val utilsModule = Kodein.Module("utils") {
  bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(instance()) }
}
