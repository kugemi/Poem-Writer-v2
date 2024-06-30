package dev.kugemi.rhymes

import dev.kugemi.rhymes.models.Rhyme
import dev.kugemi.rhymesapi.models.RhymeDTO

sealed class RequestResult(rhymes: List<Rhyme>?) {

    data object InProgress : RequestResult(null)

    class Error : RequestResult(null)

    class Success(rhymes: List<Rhyme>) : RequestResult(rhymes)
}

internal fun Result<List<RhymeDTO>>.toRequestResult(): RequestResult {
    return when {
        isSuccess -> RequestResult.Success(getOrThrow().map { it.toRhyme() })
        isFailure -> RequestResult.Error()
        else -> error("Impossible branch")
    }
}