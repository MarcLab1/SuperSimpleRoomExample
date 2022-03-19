package com.roomexamples.repo

import com.roomexamples.model.Something
import kotlinx.coroutines.flow.Flow

interface Repo {

    suspend fun insertSomething(something: Something)
    suspend fun updateSomething(something: Something)
    suspend fun deleteSomething(something: Something)

    suspend fun getSomethingById(id : Int) : Something
    suspend fun getSomethingsList() : List<Something>
    fun getSomethingsFlow() : Flow<List<Something>>
}