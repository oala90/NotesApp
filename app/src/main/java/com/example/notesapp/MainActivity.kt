package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.presentation.ui.theme.NotesAppTheme
import com.example.notesapp.presentation.ui.views.AddNoteView
import com.example.notesapp.presentation.ui.views.MainView
import com.example.notesapp.presentation.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val myViewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            NotesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPading ->

                    Column(modifier = Modifier.padding(innerPading)) {

                    }

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "MainView",
                    ) {
                        composable("MainView") {
                            val noteList by myViewModel.noteList.collectAsState()
                            LaunchedEffect(Unit) {
                                myViewModel.getAllNotes()
                            }
                            MainView(
                                notesList = noteList
                            ) {
                                navController.navigate("AddNoteView")
                            }
                        }
                        composable("AddNoteView") {
                            val content by myViewModel.content.collectAsState()
                            LaunchedEffect(Unit) {
                                myViewModel.content.value = ""
                            }

                            AddNoteView(
                                onContent = content,
                                onContentChanged = {
                                    myViewModel.content.value = it
                                },
                                {
                                    myViewModel.addNote()
                                    navController.navigateUp()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}