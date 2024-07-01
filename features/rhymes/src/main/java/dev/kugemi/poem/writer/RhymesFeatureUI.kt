package dev.kugemi.poem.writer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.kugemi.poem.writer.models.RhymesState
import dev.kugemi.poem.writer.viewmodels.RhymesViewModel

@Composable
fun Rhymes(modifier: Modifier = Modifier) {
    RhymesScreen(viewModel = viewModel(), modifier)
}

@Composable
internal fun RhymesScreen(
    viewModel: RhymesViewModel,
    modifier: Modifier
) {
    val state by viewModel.rhymesState.collectAsState()
    val currentState = state
    RhymesContent(currentState, modifier)
}

@Composable
internal fun RhymesContent(
    state: RhymesState,
    modifier: Modifier
) {
    when (state) {
        is RhymesState.None -> Unit
        is RhymesState.Error -> Unit
        is RhymesState.Loading -> Unit
        is RhymesState.Success -> RhymesList(state, modifier)
    }
}

@Composable
internal fun RhymesList(
    state: RhymesState.Success,
    modifier: Modifier
) {
    LazyColumn(modifier) {
        items(state.rhymes) { rhyme ->
            Text(text = rhyme.word)
        }
    }
}