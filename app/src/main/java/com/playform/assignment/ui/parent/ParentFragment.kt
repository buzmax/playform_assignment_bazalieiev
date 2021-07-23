package com.playform.assignment.ui.parent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.playform.assignment.core.ui.BaseFragment
import com.playform.assignment.core.util.viewModel
import com.playform.assignment.databinding.FragmentParentBinding

class ParentFragment : BaseFragment() {

  override val viewModel by viewModel<ParentViewModel>()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ) = FragmentParentBinding.inflate(inflater, container, false)
    .also { it.viewModel = viewModel }
    .root
}