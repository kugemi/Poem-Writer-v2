package dev.kugemi.rhymes

import dev.kugemi.rhymes.models.Rhyme
import dev.kugemi.rhymesapi.models.RhymeDTO

internal fun RhymeDTO.toRhyme(): Rhyme {
    return Rhyme(
        word = this.word,
        freq = this.freq,
        score = this.score,
        flags = this.flags,
        syllables = this.syllables
    )
}