package utils

sealed class Result <out T : Any> {
    data class Success<out T : Any>(val data: T) :  Result<T>()
    data class Error(val message: String) :  Result<Nothing>()
    data object Loading : Result<Nothing>()
}