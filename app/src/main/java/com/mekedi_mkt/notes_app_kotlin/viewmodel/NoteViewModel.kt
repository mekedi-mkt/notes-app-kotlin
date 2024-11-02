package com.mekedi_mkt.notes_app_kotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mekedi_mkt.notes_app_kotlin.model.entities.Note
import com.mekedi_mkt.notes_app_kotlin.model.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application, private val noteRepository: NoteRepository) :
    AndroidViewModel(app) {

    fun addNote(note: Note) =
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }


    fun updateNote(note: Note) =
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }


    fun deleteNote(note: Note) =
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }

    fun getAllNotes() = noteRepository.getAllNotes()

    fun searchNote(query: String?) =
        noteRepository.searchNote(query)
}