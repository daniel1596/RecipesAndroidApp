package com.example.recipesandroidapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @PrimaryKey val RecipeID: Int,
    @ColumnInfo(name = "Name") val Name: String,
    @ColumnInfo(name = "BasedOnLink") val BasedOnLink: String?
)