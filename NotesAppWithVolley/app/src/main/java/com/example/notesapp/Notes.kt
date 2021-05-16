package com.example.notesapp

import java.io.Serializable

data class Notes(var note_id: Int, var lecture_name: String, var note1: Int, var note2: Int) :Serializable{
}