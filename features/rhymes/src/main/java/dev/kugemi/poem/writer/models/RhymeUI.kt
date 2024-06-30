package dev.kugemi.poem.writer.models

data class RhymeUI(
    val word: String,
    val freq: Int,
    val score: Int,
    val flags: String,
    val syllables: Int
)
