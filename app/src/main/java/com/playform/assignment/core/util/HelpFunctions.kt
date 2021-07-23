package com.playform.assignment.core.util

import androidx.annotation.MainThread
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.playform.assignment.core.ui.BaseFragment
import org.kodein.di.DKodein
import org.kodein.di.Kodein.Builder
import org.kodein.di.Kodein.Builder.TypeBinder
import org.kodein.di.generic.bind
import org.kodein.di.generic.instanceOrNull

inline fun <reified T : ViewModel> Builder.bindViewModel(overrides: Boolean? = null): TypeBinder<T> =
  bind<T>(T::class.java.simpleName, overrides)

class ViewModelFactory(private val injector: DKodein) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return injector.instanceOrNull<ViewModel>(tag = modelClass.simpleName) as T?
      ?: modelClass.newInstance()
  }
}

@MainThread
inline fun <reified VM : ViewModel> BaseFragment.viewModel() =
  viewModels<VM>(
    ownerProducer = { this },
    factoryProducer = { this.viewModelFactory }
  )