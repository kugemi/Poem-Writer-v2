package dev.kugemi.rhymesapi.models

import kotlinx.serialization.SerialName

data class RhymeDTO(
    @SerialName("word") val word: String,
    @SerialName("freq") val freq: Int,
    @SerialName("score") val score: Int,
    @SerialName("flags") val flags: String,
    @SerialName("syllables") val syllables: Int
)