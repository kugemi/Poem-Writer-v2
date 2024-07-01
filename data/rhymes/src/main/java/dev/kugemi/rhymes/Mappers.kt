package dev.kugemi.rhymes

import dev.kugemi.rhymes.models.Language
import dev.kugemi.rhymes.models.Rhyme
import dev.kugemi.rhymesapi.models.LanguageSerializable
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

internal fun Language.toLanguageSerializable(): LanguageSerializable {
    return when (this) {
        Language.EN -> LanguageSerializable.EN
        Language.DE -> LanguageSerializable.DE
        Language.FR -> LanguageSerializable.FR
        Language.ES -> LanguageSerializable.ES
        Language.RU -> LanguageSerializable.RU
    }
}