package com.example.recipesandroidapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Note (
    @PrimaryKey val NoteID: Int,
    @ColumnInfo val Text: String
)