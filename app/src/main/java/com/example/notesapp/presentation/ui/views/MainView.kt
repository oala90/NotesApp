package com.example.notesapp.presentation.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesapp.domain.entity.NoteEntity

@Composable
fun MainView(
    notesList: List<NoteEntity>,
    navigateToAddNote: () -> Unit
) {
    Scaffold(
//        backgroundColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            FloatingActionButton(onClick = navigateToAddNote) {
                Icon(Icons.Default.Add, contentDescription = "Add Note")
            }
        },
        content = { paddingValues ->
            LazyColumn(
                contentPadding = paddingValues
            ) {
                items(notesList) { item ->
                    NoteCard(note = item)
                }
            }
        }
    )
}

@Composable
fun NoteCard(note: NoteEntity) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = note.content,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    val sampleNotes = listOf(
        NoteEntity(1, "This is the content of note 1"),
        NoteEntity(2, "This is the content of note 2"),
        NoteEntity(3, "This is the content of note 3")
    )

    MainView(
        notesList = sampleNotes,
        navigateToAddNote = {}
    )
}