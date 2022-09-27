package com.example.application.retrofit

import com.example.application.model.Project
import retrofit2.Response
import retrofit2.http.GET

interface ProjectAPI {

    @GET("repos")
    suspend fun getProjects(): Response<List<Project>>
}