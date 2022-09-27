package com.example.application.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.application.model.Project

@Dao
interface ProjectDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProjects(projects: List<Project>)

    @Query("SELECT * FROM Project")
    suspend fun getProjects(): List<Project>

}