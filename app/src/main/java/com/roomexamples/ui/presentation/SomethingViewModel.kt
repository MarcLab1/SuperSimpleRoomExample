package com.roomexamples.ui.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.roomexamples.model.Something
import com.roomexamples.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SomethingViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {

    var flow = repo.getSomethingsFlow()
    var liveData = flow.asLiveData() //never put live data inside a repo, so we can "cheat" and get it this way
    var listOfBooks : MutableState<List<Something>> = mutableStateOf(listOf())

    init {
       updateListOfBooks()
    }

    fun insert()
    {
        viewModelScope.launch {
            repo.insertSomething(Something())
        }
    }
    fun delete(id : Int)
    {
        viewModelScope.launch {
            repo.deleteSomething(repo.getSomethingById(id))
        }
    }

    fun updateListOfBooks()
    {
        viewModelScope.launch {
            listOfBooks.value = repo.getSomethingsList()
        }
    }
}