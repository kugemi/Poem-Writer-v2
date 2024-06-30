package dev.kugemi.rhymes.models

data class Rhyme(
    val word: String,
    val freq: Int,
    val score: Int,
    val flags: String,
    val syllables: Int
)