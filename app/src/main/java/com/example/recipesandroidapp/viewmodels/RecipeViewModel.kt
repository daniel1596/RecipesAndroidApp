package com.example.recipesandroidapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesandroidapp.room.Recipe
import com.example.recipesandroidapp.room.RecipeDatabase
import kotlinx.coroutines.launch

/**
 * Not sure if this is what I want? But maybe?
 */
class RecipeViewModel(name: String) : ViewModel() {
    val name = name
    val recipe: Recipe? = null

    suspend fun getRecipe() {
        viewModelScope.launch {
            // db.
        }
    }
}