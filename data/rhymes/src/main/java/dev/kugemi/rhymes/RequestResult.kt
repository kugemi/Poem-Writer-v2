package dev.kugemi.rhymes

import dev.kugemi.rhymes.models.Rhyme
import dev.kugemi.rhymesapi.models.RhymeDTO

sealed class RequestResult<T>(open val rhymes: T?) {

    class InProgress<T> : RequestResult<T>(null)

    class Error<T> : RequestResult<T>(null)

    class Success<T>(override val rhymes: T) : RequestResult<T>(rhymes)
}

fun <I, O> RequestResult<I>.map(mapper: (I) -> O): RequestResult<O> {
    return when (this) {
        is RequestResult.InProgress -> RequestResult.InProgress()
        is RequestResult.Error -> RequestResult.Error()
        is RequestResult.Success -> RequestResult.Success(mapper(rhymes))
    }
}

internal fun <T> Result<T>.toRequestResult(): RequestResult<T> {
    return when {
        isSuccess -> RequestResult.Success(getOrThrow())
        isFailure -> RequestResult.Error()
        else -> error("Impossible branch")
    }
}