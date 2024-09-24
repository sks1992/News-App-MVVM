package sk.sandeep.newsappmvvm.utils

sealed class ApiStatus<T>(val data: T? = null, val message: Throwable? = null) {
    class Empty<T> : ApiStatus<T>()
    class Loading<T> :ApiStatus<T>()
    class Success<T>(data: T):ApiStatus<T>(data)
    class Failure<T>(message: Throwable,data: T? =null):ApiStatus<T>(data, message)
}