package com.playform.assignment.core.ui

import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

abstract class BaseViewModel : ViewModel() {

  val message = LiveEvent<Message>()
  val showProgress = LiveEvent<Boolean>()
  // TODO: 7/23/21 not the best decision, needs to be improved
  val navigation = LiveEvent<Int>()

  protected fun notifyMsg(resId: Int) = message.postValue(Message.ResId(resId))
  protected fun notifyMsg(value: String) = message.postValue(Message.Value(value))

  protected fun showProgress() = showProgress.postValue(true)
  protected fun hideProgress() = showProgress.postValue(false)
}