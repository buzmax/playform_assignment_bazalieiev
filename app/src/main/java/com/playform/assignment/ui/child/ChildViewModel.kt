package com.playform.assignment.ui.child

import android.content.res.Resources
import android.provider.SyncStateContract
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.playform.assignment.R
import com.playform.assignment.core.ui.BaseViewModel
import com.playform.assignment.core.util.STAR_IMAGE
import com.playform.assignment.core.util.SUN_IMAGE
import com.playform.assignment.model.data.Result
import com.playform.assignment.model.data.Todo
import com.playform.assignment.model.usecase.GetCurrentTodoIdUseCase
import com.playform.assignment.model.usecase.GetTodoUseCase
import kotlinx.coroutines.launch

class ChildViewModel(
  private val getTodoUseCase: GetTodoUseCase,
  private val getCurrentTodoIdUseCase: GetCurrentTodoIdUseCase,
  private val resources: Resources
) : BaseViewModel() {

  val header = ObservableField<String>()
  val image = ObservableField<String>()
  val title = ObservableField<String>()
  val userId = ObservableField<String>()

  init {
    viewModelScope.launch {
      showProgress()
      val id = getCurrentTodoIdUseCase.getCurrentId()
      // TODO: 7/23/21 try to not use resources here
      header.set(resources.getString(R.string.child_header_template, id))
      when (val todo = getTodoUseCase.getTodo(id)) {
        is Result.Success -> fillContent(todo.data)
        // TODO: 7/23/21 handle errors properly
        is Result.Error -> notifyMsg(R.string.generic_error)
      }
      hideProgress()
    }
  }

  private fun fillContent(todo: Todo) {
    title.set(resources.getString(R.string.title_template, todo.title))
    userId.set(resources.getString(R.string.user_id_template, todo.userId))
    image.set(if (todo.completed) STAR_IMAGE else SUN_IMAGE)
  }
}