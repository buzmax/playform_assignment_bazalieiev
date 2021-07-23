package com.playform.assignment.ui.di

import com.playform.assignment.core.util.bindViewModel
import com.playform.assignment.ui.child.ChildViewModel
import com.playform.assignment.ui.parent.ParentViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val uiModule = Kodein.Module("ui") {
    bindViewModel<ParentViewModel>() with provider { ParentViewModel() }
    bindViewModel<ChildViewModel>() with provider {
        ChildViewModel(
            instance(),
            instance(),
            instance()
        )
    }
}