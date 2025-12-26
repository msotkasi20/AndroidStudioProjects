package com.example.ktorkotlinx.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorkotlinx.data.TodoRepository
import com.example.ktorkotlinx.models.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class TodoUiState(
    val todos: List<Todo> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

class TodoViewModel: ViewModel() {
    private val repository = TodoRepository()
    private val _uiState = MutableStateFlow(TodoUiState())
    val uiState: StateFlow<TodoUiState> = _uiState.asStateFlow()

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
            try {
                val todos = repository.getTodos()
                _uiState.value = _uiState.value.copy(todos = todos, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = "Error: ${e.message}"
                )
                e.printStackTrace()
            }
        }
    }

    fun addTodo(title: String) {
        viewModelScope.launch {
            try {
                val newTodo =
                    Todo(userId = 1, id = 0, title = title, completed = false)
                val addedTodo = repository.addTodo(newTodo)

                // Add the returned todo to our list
                val currentTodos = _uiState.value.todos.toMutableList()
                currentTodos.add(0, addedTodo) // Add to top
                _uiState.value = _uiState.value.copy(todos = currentTodos)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    errorMessage = "Error adding todo: ${e.message}"
                )
                e.printStackTrace()
            }
        }
    }
}