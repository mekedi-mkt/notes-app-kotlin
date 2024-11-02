package com.mekedi_mkt.notes_app_kotlin.model.repository

import com.mekedi_mkt.notes_app_kotlin.model.database.NoteDatabase
import com.mekedi_mkt.notes_app_kotlin.model.entities.Note

class NoteRepository(private val db: NoteDatabase) {
    suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query: String?) = db.getNoteDao().searchNote(query)
}
