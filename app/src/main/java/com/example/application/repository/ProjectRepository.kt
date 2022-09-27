package com.example.application.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.application.db.ProjectDB
import com.example.application.model.Project
import com.example.application.retrofit.ProjectAPI
import javax.inject.Inject

class ProjectRepository @Inject constructor(
    private val projectAPI: ProjectAPI,
    private val projectDB: ProjectDB
) {

    private val _projects = MutableLiveData<List<Project>>()
    val projects: LiveData<List<Project>>
        get() = _projects

    suspend fun getProjects() {
        projectDB.getProjectDAO().getProjects()
        val result = projectAPI.getProjects()
        if (result.isSuccessful && result.body() != null) {
            projectDB.getProjectDAO().addProjects(result.body()!!)
            _projects.postValue(projectDB.getProjectDAO().getProjects())
        }
    }

}