package com.playform.assignment.core.network

import android.content.res.Resources
import com.playform.assignment.R
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiClient(client: OkHttpClient, resources: Resources) {

    val generalApi: Retrofit = Retrofit.Builder()
        .baseUrl(resources.getString(R.string.base_url))
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .client(client)
        .build()
}