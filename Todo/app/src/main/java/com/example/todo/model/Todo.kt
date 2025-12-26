package com.example.todo.model

data class Todo (
    //@SerializedName("userId") var uID: Int
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)