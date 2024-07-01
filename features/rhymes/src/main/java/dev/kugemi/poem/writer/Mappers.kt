package dev.kugemi.poem.writer

import dev.kugemi.poem.writer.models.RhymeUI
import dev.kugemi.poem.writer.models.RhymesState
import dev.kugemi.rhymes.RequestResult
import dev.kugemi.rhymes.models.Rhyme

internal fun Rhyme.toRhymeUI(): RhymeUI {
    return RhymeUI(
        word = this.word,
        freq = this.freq,
        score = this.score,
        flags = this.flags,
        syllables = this.syllables
    )
}

internal fun RequestResult<List<RhymeUI>>.toState(): RhymesState {
    return when (this) {
        is RequestResult.InProgress -> RhymesState.Loading()
        is RequestResult.Error -> RhymesState.Error()
        is RequestResult.Success -> RhymesState.Success(rhymes)
    }
}