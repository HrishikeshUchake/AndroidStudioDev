package com.example.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val _categoryState = mutableStateOf(recipeState())
    val categoriesState: State<recipeState> = _categoryState

    init {
        fetchCatergories()
    }

    private fun fetchCatergories(){
        viewModelScope.launch {
            try {
              val response = recipeService.getCategories()
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    categories = response.categories,
                    error = null
                )

            } catch (e: Exception){
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    data class recipeState(
        val loading : Boolean = true,
        val categories: List<Category> = emptyList(),
        val error: String? = null

    )
}