package com.example.navigation3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.navigation3.note.NoteDetailsScreenUI
import com.example.navigation3.note.NoteListScreenUI
import kotlinx.serialization.Serializable

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
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider = { key ->
            when (key) {
                is NoteListScreen -> {
                    NavEntry(
                        key = key
                    ) {
                        NoteListScreenUI(
                            onNoteClick = { noteId ->
                                // TODO: fix this later
                                //backStack.add(NoteDetailsScreenUI())
                            }
                        )
                    }
                }

                is NoteDetailScreen -> {
                    NavEntry(
                        key = key
                    ) {
                        NoteDetailsScreenUI(id = key.id)
                    }
                }

                else -> error("Unknown navigation key: $key")
            }

        },
        modifier = modifier,

        )
}