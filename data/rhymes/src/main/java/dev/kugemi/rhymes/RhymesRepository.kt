package dev.kugemi.rhymes

import dev.kugemi.rhymes.models.Language
import dev.kugemi.rhymes.models.Rhyme
import dev.kugemi.rhymesapi.RhymesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

class RhymesRepository @Inject constructor(
    private val api: RhymesApi
) {
    public fun getRhymes(word: String, language: Language = Language.EN): Flow<RequestResult<List<Rhyme>>> {
        val apiRequest = flow { emit(api.getRhymes(
            function = RHYMES_FUNCTION,
            word = word,
            language = language.toLanguageSerializable()
        )) }
            .map { result ->
                result.map { rhymes ->
                    rhymes.map { it.toRhyme() }
                }
            }
            .map { result -> result.toRequestResult() }

        val start = flowOf<RequestResult<List<Rhyme>>>(RequestResult.InProgress())

        return merge(start, apiRequest)
    }

    companion object {
        private const val RHYMES_FUNCTION = "getRhymes"
    }
}