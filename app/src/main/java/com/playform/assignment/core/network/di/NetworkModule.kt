package com.playform.assignment.core.network.di

import com.playform.assignment.core.network.Api
import com.playform.assignment.core.network.ApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val networkModule = Kodein.Module("network") {
  bind<OkHttpClient>() with singleton {
    OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().apply { level = BODY })
      .build()
  }
  bind<ApiClient>() with singleton { ApiClient(instance(), instance()) }
  bind<Api>() with singleton { instance<ApiClient>().generalApi.create(Api::class.java) }
}