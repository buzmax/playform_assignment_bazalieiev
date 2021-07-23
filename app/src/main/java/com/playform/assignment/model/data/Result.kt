package com.playform.assignment.model.data

sealed class Result<out T> {

  data class Success<out T>(val data: T) : Result<T>()
  data class Error(val message: String, val throwable: Throwable? = null) : Result<Nothing>()

  override fun toString(): String {
    return when (this) {
      is Success<*> -> "Success[data = $data]"
      is Error -> "Error[message = $message; throwable = $throwable]"
    }
  }

  companion object {
    fun <T> withData(data: T): Result<T> = Success(data)
    fun <T> withError(throwable: Throwable): Result<T> = throwable.asResult()
  }
}

fun <T> Throwable.asResult(): Result<T> {
  return Result.Error(
    message = this.message.orEmpty(),
    throwable = this
  )
}
