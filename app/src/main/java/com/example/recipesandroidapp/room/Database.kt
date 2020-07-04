package com.example.recipesandroidapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Recipe::class), version = 1)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

    suspend fun loadAllRecipes(): List<Recipe> {
        return recipeDao().all()
    }

    suspend fun loadRecipeByName(name: String): Recipe {
        return recipeDao().getRecipeByName(name)
    }
}

