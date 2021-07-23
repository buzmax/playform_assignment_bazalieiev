package com.playform.assignment.ui.parent

import com.playform.assignment.R
import com.playform.assignment.core.ui.BaseViewModel

class ParentViewModel : BaseViewModel() {

  fun goToChild() {
    // TODO: 7/23/21 not the best decision, needs to be improved
    navigation.postValue(R.id.fragment_child)
  }
}
