package com.rash.notesapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.rash.notesapp.database.Note
import com.rash.notesapp.database.RoomDBHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NoteViewModel(app: Application) : AndroidViewModel(app) {

    private val db: RoomDBHelper = RoomDBHelper.getInstance(app)

    fun upsertNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) { db.noteDao.upsertNote(note) }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) { db.noteDao.deleteNote(note) }
    }

    fun getNotes() = db.noteDao.getAllNotes()

}