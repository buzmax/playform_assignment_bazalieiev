package com.playform.assignment.core.network

import com.playform.assignment.core.network.dto.TodoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("todos/{id}")
    suspend fun getTodo(@Path("id") id: Int): TodoResponse
}