package com.example.recipesandroidapp.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface RecipeDao {
    // Interested in potentially passing in a boolean but maybe that's not good practice.
    // For now, ordering by name is fine. Let's just get some shit working.
    @Query("SELECT * FROM Recipe ORDER BY Name asc")
    suspend fun all(): List<Recipe>

    @Query("SELECT * FROM Recipe WHERE Name like :Name LIMIT 1")
    suspend fun getRecipeByName(Name: String): Recipe
}

