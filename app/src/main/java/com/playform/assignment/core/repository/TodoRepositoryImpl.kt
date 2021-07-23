package com.playform.assignment.core.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.playform.assignment.core.network.Api
import com.playform.assignment.core.network.GeneralNetworkException
import com.playform.assignment.model.data.Todo
import com.playform.assignment.model.repository.TodoRepository
import com.playform.assignment.model.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoRepositoryImpl(
  private val api: Api,
  private val sharedPreferences: SharedPreferences
) : TodoRepository {
  override suspend fun getTodo(id: Int): Result<Todo> = withContext(Dispatchers.IO) {
    try {
      val response = api.getTodo(id)
      // TODO: 7/23/21 extract mapping to separate component
      Result.withData(Todo(response.userId, response.id, response.title, response.completed))
    } catch (t: Throwable) {
      // TODO: 7/23/21 handle errors properly
      Result.withError(GeneralNetworkException())
    }
  }

  override suspend fun getTodoId(): Int = withContext(Dispatchers.IO) {
    // TODO: 7/23/21 extract it to separate entity, some Data source, do not use Shared prefs directly here
    var currentID = sharedPreferences.getInt(CURRENT_ID, 1)
    currentID++
    sharedPreferences.edit { putInt(CURRENT_ID, currentID) }
    currentID
  }
}

private const val CURRENT_ID = "CURRENT_ID"