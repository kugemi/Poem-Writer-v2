package dev.kugemi.rhymes

import dev.kugemi.rhymes.models.Rhyme
import dev.kugemi.rhymesapi.RhymesApi
import dev.kugemi.rhymesapi.models.Language
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge

class RhymesRepository(
    private val api: RhymesApi
) {
    public fun getRhymes(word: String, language: Language = Language.EN): Flow<RequestResult> {
        val apiRequest = flow { emit(api.getRhymes(
            function = RHYMES_FUNCTION,
            word = word,
            language = language
        )) }.map { result -> result.toRequestResult() }

        val start = flowOf<RequestResult>(RequestResult.InProgress)

        return merge(start, apiRequest)
    }

    companion object {
        private const val RHYMES_FUNCTION = "getRhymes"
    }
}