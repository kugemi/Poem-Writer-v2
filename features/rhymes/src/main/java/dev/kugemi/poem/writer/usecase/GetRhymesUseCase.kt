package dev.kugemi.poem.writer.usecase

import dev.kugemi.rhymes.models.Language
import dev.kugemi.poem.writer.models.RhymeUI
import dev.kugemi.poem.writer.toRhymeUI
import dev.kugemi.rhymes.RequestResult
import dev.kugemi.rhymes.RhymesRepository
import dev.kugemi.rhymes.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRhymesUseCase @Inject constructor(
    private val repository: RhymesRepository
) {
    operator fun invoke(word: String, language: Language): Flow<RequestResult<List<RhymeUI>>> {
        return repository.getRhymes(word, language).map { requestResult ->
            requestResult.map { rhymes ->
                rhymes.map { it.toRhymeUI() }
            }
        }
    }
}