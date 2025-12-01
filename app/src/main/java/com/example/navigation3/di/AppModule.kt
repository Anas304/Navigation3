package com.example.navigation3.di

import com.example.navigation3.note.NoteDetailsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::NoteDetailsViewModel)
}