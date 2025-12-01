package com.example.navigation3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.scene.DialogSceneStrategy
import androidx.navigation3.ui.NavDisplay
import com.example.navigation3.note.NoteDetailsScreenUI
import com.example.navigation3.note.NoteListScreenUI
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Serializable
object NoteListScreen : NavKey

@Serializable
data class NoteDetailScreen(val id: Int) : NavKey

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(NoteListScreen)

    NavDisplay(
        backStack = backStack,
        sceneStrategy = DialogSceneStrategy(),
        entryProvider = { key ->
            when (key) {
                is NoteListScreen -> {
                    NavEntry(
                        key = key
                    ) {
                        NoteListScreenUI(
                            onNoteClick = { noteId ->
                                // TODO: fix this later
                                backStack.add(NoteDetailScreen(noteId))
                            }
                        )
                    }
                }

                is NoteDetailScreen -> {
                    NavEntry(
                        key = key,
                        metadata = DialogSceneStrategy.dialog()
                    ) {
                        NoteDetailsScreenUI(
                            viewModel = koinViewModel {
                                parametersOf(key.id)
                            }
                        )
                    }
                }

                else -> error("Unknown navigation key: $key")
            }

        },
        modifier = modifier,

        )
}