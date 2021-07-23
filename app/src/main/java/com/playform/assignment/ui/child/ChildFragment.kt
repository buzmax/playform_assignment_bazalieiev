package com.playform.assignment.ui.child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.playform.assignment.core.ui.BaseFragment
import com.playform.assignment.core.util.viewModel
import com.playform.assignment.databinding.FragmentChildBinding

class ChildFragment : BaseFragment() {
  override val viewModel by viewModel<ChildViewModel>()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ) = FragmentChildBinding.inflate(inflater, container, false)
    .also { it.viewModel = viewModel }
    .root
}