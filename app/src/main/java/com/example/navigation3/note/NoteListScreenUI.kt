package com.example.navigation3.note

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NoteListScreenUI(
    onNoteClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(sampleNotes) {
            NoteItem(note = it, onNoteClick = onNoteClick)
        }
    }
}

@Composable
fun NoteItem(
    note: Note,
    onNoteClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(note.color)
            .clickable(onClick = {
                onNoteClick(note.id)
            }),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(text = note.title, style = MaterialTheme.typography.titleLarge)
        Text(text = note.content, style = MaterialTheme.typography.bodyMedium)
    }
}