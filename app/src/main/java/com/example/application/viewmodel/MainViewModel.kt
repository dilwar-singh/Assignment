package com.example.application.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application.model.Project
import com.example.application.repository.ProjectRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: ProjectRepository,
    private val randomize: Randomize
) : ViewModel() {

    val projectsLiveData: LiveData<List<Project>>
        get() = repository.projects

    init {
        viewModelScope.launch {
            repository.getProjects()
        }
    }

}

class Randomize @Inject constructor() {
    fun doAction() {
    }
}