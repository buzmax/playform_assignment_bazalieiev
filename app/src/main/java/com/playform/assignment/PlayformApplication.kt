package com.playform.assignment

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.playform.assignment.core.network.di.networkModule
import com.playform.assignment.core.repository.di.repoModule
import com.playform.assignment.core.usecase.di.useCaseModule
import com.playform.assignment.core.util.di.utilsModule
import com.playform.assignment.ui.di.uiModule
import org.kodein.di.*
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

class PlayformApplication : Application(), KodeinAware {

  override val kodein = Kodein {
    import(uiModule)
    import(utilsModule)
    import(networkModule)
    import(repoModule)
    import(useCaseModule)
    bind<DKodein>() with provider { kodein.direct }
    bind<Resources>() with provider { resources }
    bind<SharedPreferences>() with provider {
      getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
    }
  }

  override val kodeinTrigger = KodeinTrigger()

  override fun onCreate() {
    super.onCreate()
    kodeinTrigger.trigger()
  }
}

