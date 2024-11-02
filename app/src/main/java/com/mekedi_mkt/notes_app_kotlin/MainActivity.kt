package com.mekedi_mkt.notes_app_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mekedi_mkt.notes_app_kotlin.model.database.NoteDatabase
import com.mekedi_mkt.notes_app_kotlin.model.repository.NoteRepository
import com.mekedi_mkt.notes_app_kotlin.viewmodel.NoteViewModel
import com.mekedi_mkt.notes_app_kotlin.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        setUpViewModel()
    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}