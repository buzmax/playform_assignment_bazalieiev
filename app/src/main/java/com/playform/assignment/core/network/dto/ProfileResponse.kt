package com.playform.assignment.core.network.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TodoResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
)