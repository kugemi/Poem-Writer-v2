package dev.kugemi.poem.writer.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kugemi.poem.writer.models.RhymesState
import dev.kugemi.poem.writer.toState
import dev.kugemi.poem.writer.usecase.GetRhymesUseCase
import dev.kugemi.rhymes.models.Language
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.transform
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class RhymesViewModel @Inject internal constructor(
    getRhymesUseCase: Provider<GetRhymesUseCase>
): ViewModel() {
    private val _rhymesState: StateFlow<RhymesState> = MutableStateFlow(RhymesState.None)

    val rhymesState: StateFlow<RhymesState> = getRhymesUseCase.get().invoke(word = "test", language = Language.EN)
        .map { it.toState() }
        .stateIn(viewModelScope, SharingStarted.Lazily, RhymesState.None)
}