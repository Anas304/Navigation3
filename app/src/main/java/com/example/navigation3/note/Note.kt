package com.example.navigation3.note

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val color : Color
)


val sampleNotes = (0 until  100).map{
    Note(
        id = it,
        title = "Title $it",
        content = "Content $it",
        color = Color(Random.nextLong(0xFFFFFFFF)).copy(alpha = 0.5f)
    )
}