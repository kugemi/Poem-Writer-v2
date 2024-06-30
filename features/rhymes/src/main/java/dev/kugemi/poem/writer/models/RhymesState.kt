package dev.kugemi.poem.writer.models

sealed class RhymesState(rhymes: List<RhymeUI>?) {

    data object None : RhymesState(null)

    class Loading : RhymesState(null)

    class Error : RhymesState(null)

    class Success(rhymes: List<RhymeUI>) : RhymesState(rhymes)
}