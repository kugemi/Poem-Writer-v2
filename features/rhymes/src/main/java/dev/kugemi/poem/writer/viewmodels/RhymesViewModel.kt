package dev.kugemi.poem.writer.viewmodels

import androidx.lifecycle.ViewModel
import dev.kugemi.poem.writer.models.RhymesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RhymesViewModel : ViewModel() {
    private val _rhymesState: StateFlow<RhymesState> = MutableStateFlow(RhymesState.None)

    val rhymesStat: StateFlow<RhymesState>
        get() = _rhymesState
}