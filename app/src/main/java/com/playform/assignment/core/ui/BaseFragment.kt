package com.playform.assignment.core.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

abstract class BaseFragment : Fragment(), KodeinAware {
    abstract val viewModel: BaseViewModel

    val viewModelFactory: ViewModelProvider.Factory by instance()

    override val kodein: Kodein by closestKodein()

    private var progressDialog: Dialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeForLiveDataEvents(viewModel)
    }

    private fun subscribeForLiveDataEvents(viewModel: BaseViewModel) {
        viewModel.message.observe(viewLifecycleOwner) {
            when (it) {
                is Message.ResId -> Snackbar.make(requireView(), it.id, Snackbar.LENGTH_LONG).show()
                is Message.Value -> Snackbar.make(requireView(), it.value, Snackbar.LENGTH_LONG).show()
            }
        }
        viewModel.showProgress.observe(viewLifecycleOwner) {
            if (it) showProgressDialog() else hideProgressDialog()
        }
        // TODO: 7/23/21 not the best decision, needs to be improved
        viewModel.navigation.observe(viewLifecycleOwner) { findNavController().navigate(it) }
    }

    private fun showProgressDialog() {
        progressDialog = Dialog(requireContext()).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(ProgressBar(requireContext()))
            setCancelable(false)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }
    }

    private fun hideProgressDialog() {
        progressDialog?.dismiss()
    }
}