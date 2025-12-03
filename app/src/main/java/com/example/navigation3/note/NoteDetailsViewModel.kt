package com.example.navigation3.note

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NoteDetailsViewModel(
   private val noteId: Int
) : ViewModel() {

    private val _note = MutableStateFlow(sampleNotes.first{it.id == noteId})
    val note = _note.asStateFlow()
}