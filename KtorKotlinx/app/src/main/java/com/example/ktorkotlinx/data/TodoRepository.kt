package com.example.ktorkotlinx.data

import com.example.ktorkotlinx.models.Todo
import com.example.ktorkotlinx.network.TodoClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class TodoRepository {
    private val client = TodoClient.client

    suspend fun getTodos() : List<Todo> {
        return client.get("https://jsonplaceholder.typicode.com/todos").body()
    }

    suspend fun addTodo(todo: Todo): Todo {
        return client.post("https://jsonplaceholder.typicode.com/todos") {
            contentType(ContentType.Application.Json)
            setBody(todo)
        }.body()
    }
}